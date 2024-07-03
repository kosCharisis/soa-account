package gr.aueb.cf.accounts;

import gr.aueb.cf.accounts.dao.AccountDAOImpl;
import gr.aueb.cf.accounts.dao.IAccountDAO;
import gr.aueb.cf.accounts.dto.*;
import gr.aueb.cf.accounts.model.Account;
import gr.aueb.cf.accounts.model.UserDetails;
import gr.aueb.cf.accounts.service.AccountServiceImpl;
import gr.aueb.cf.accounts.service.IAccountService;
import gr.aueb.cf.accounts.service.exceptions.AccountNotFoundException;
import gr.aueb.cf.accounts.service.exceptions.IbanAlreadyExistsException;
import gr.aueb.cf.accounts.service.exceptions.UserUuidAlreadyExistsException;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    //Wiring
    private final static IAccountDAO dao = new AccountDAOImpl();
    private final static IAccountService service = new AccountServiceImpl(dao);

    public static void main(String[] args) {
        String choice = "";

        while (true) {
            printMenu();
            System.out.println("Παρακαλώ εισάγετε επιλογή");
            choice = getChoice();

            if (choice.matches("[qQ]")) {
                System.out.println("Goodbye. Thanks for using our app");
                break;
            }

            if (!choice.matches("[1-5]")) {
                System.out.println("Λάθος επιλογή");
                continue;
            }

            processWithChoice(choice);
        }
    }
    public static void processWithChoice(String choice) {
        Account account;
        String uuid;
        String iban;

        switch (choice) {
            case "1":
                account = getAccount();
                insertAccount (account);
                break;
            case "2":
                System.out.println("Παρακαλώ δώστε το uuid του λογαριασμού προς ενημέρωση");
                uuid = scanner.next();
                System.out.println("Παρακάλω εισάγετε τα στοιχεία του νέου λογαριασμού");
                account = getAccount();
                updateAccount(uuid, account);
                break;
            case "3":
                System.out.println("Παρακαλώ δώστε το uuid του λογαριασμού προς διαγραφή");
                uuid = scanner.next();
                deleteAccount(uuid);
                break;
            case "4":
                System.out.println("Παρακαλώ δώστε το IBAN του λογαριασμού προς αναζήτηση");
                iban = scanner.nextLine().trim();
                AccountReadOnlyDTO dto = getAccountByIban(iban);
                if (dto == null) {
                    System.out.println("Ο λογαριασμός δεν βρέθηκε");
                } else {
                    System.out.println(dto);
                }
                break;
            case "5":
                List<AccountReadOnlyDTO> accounts = getAccounts();
                printAccounts(accounts);
                break;
            default:
                System.out.println("Generic error.");
                break;
        }
    }

    private static void printAccounts(List<AccountReadOnlyDTO> accounts) {
        accounts.forEach(System.out::println);
    }

    public static void insertAccount(Account account) {
        try {
            AccountInsertDTO insertDTO = mapToAccountInsertDto (account);
            Account mc = service.insertAccount(insertDTO);
            System.out.println("Επιτυχής εισαγωγή:" + mc);
        } catch (IbanAlreadyExistsException | UserUuidAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateAccount(String uuid, Account account) {
        try {
            AccountUpdateDTO updateDTO = mapToAccountUpdateDto(account);
            Account mc = service.updateAccount(uuid, updateDTO);
            System.out.println("Επιτυχής ενημέρωση: " + mc);
        } catch (IbanAlreadyExistsException | UserUuidAlreadyExistsException | AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<AccountReadOnlyDTO> getAccounts() {
        List<Account> accounts = service.getAllAccounts();
        return mapToAccountReadOnlyDto(accounts);
    }



    public static void deleteAccount(String uuid) {
        try {
            service.deleteAccountByUuid(uuid);
            System.out.println("Επιτύχης διαγραφή");
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static AccountReadOnlyDTO getAccountByIban (String iban) {
        Account mc = null;
        try {
            mc = service.getAccountByIban(iban);
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
        if (mc == null) return null;
        return mapToAccountReadOnlyDto(mc);
    }



    public static Account getAccount() {
        Account account = new Account();

        System.out.println("Παρακαλώ εισάγετε τον κωδικό του λογαριασμού");
        account.setUuid(scanner.next());

        UserDetails userDetails = new UserDetails();
        System.out.println("Παρακαλώ εισάγετε τον κωδικό του χρήστη");
        userDetails.setUuid(scanner.next());

        scanner.nextLine(); //consume new line, enter

        System.out.println("Παρακαλώ εισάγετε το όνομα");
        userDetails.setFirstname(scanner.nextLine());

        System.out.println("Παρακαλώ εισάγετε το επώνυμο");
        userDetails.setLastname(scanner.nextLine());

        System.out.println("Παρακαλώ εισάγετε το ssn");
        userDetails.setSsn(scanner.nextLine());

        System.out.println("Παρακαλώ εισάγετε τον Iban");
        account.setIban(scanner.nextLine());

        System.out.println("Παρακαλώ εισάγετε το ποσό");
        account.setBalance(Double.parseDouble(scanner.nextLine()));

        account.setUserDetails((userDetails));
        return account;
    }

    private static UserDetailsInsertDTO mapToUserDetailsInsertDto(UserDetails userDetails) {
        return new UserDetailsInsertDTO(userDetails.getUuid(), userDetails.getFirstname(), userDetails.getLastname(), userDetails.getSsn());
    }

    private static AccountInsertDTO mapToAccountInsertDto(Account account) {
        return new AccountInsertDTO(account.getUuid(),
                mapToUserDetailsInsertDto(account.getUserDetails()), account.getIban(), account.getBalance());
    }

    private static UserDetailsUpdateDTO mapToUserDetailsUpdateDto(UserDetails userDetails) {
        return new UserDetailsUpdateDTO(userDetails.getUuid(), userDetails.getFirstname(), userDetails.getLastname(), userDetails.getSsn());
    }

    private static AccountUpdateDTO mapToAccountUpdateDto(Account account) {
        return new AccountUpdateDTO(account.getUuid(),
                mapToUserDetailsUpdateDto(account.getUserDetails()), account.getIban(), account.getBalance());
    }

    private static UserDetailsReadOnlyDTO mapToUserDetailsReadOnlyDto(UserDetails userDetails) {
        return new UserDetailsReadOnlyDTO(userDetails.getUuid(), userDetails.getFirstname(), userDetails.getLastname(),userDetails.getSsn());
    }

    private static AccountReadOnlyDTO mapToAccountReadOnlyDto(Account account) {
        return new AccountReadOnlyDTO(account.getUuid(),
                mapToUserDetailsReadOnlyDto(account.getUserDetails()), account.getIban(), account.getBalance());
    }

    private static List<AccountReadOnlyDTO> mapToAccountReadOnlyDto(List<Account> accounts) {
        List<AccountReadOnlyDTO> accountReadOnlyDTOS = new ArrayList<>();
        for (Account account : accounts) {
            accountReadOnlyDTOS.add(mapToAccountReadOnlyDto(account));
        }
        return accountReadOnlyDTOS;
    }

    public static void printMenu() {
        System.out.println("Επιλέξτε ένα από τα παρακάτω");
        System.out.println("1. Εισαγωγή λογαριασμού");
        System.out.println("2. Ενημέρωση λογαριασμού");
        System.out.println("3. Διαγραφή λογαριασμού");
        System.out.println("4. Αναζήτηση λογαριασμού με IBAN");
        System.out.println("5. Εκτύπωση λογαριασμών");
        System.out.println("6. q/Q για έξοδο");
    }

    public static String getChoice() {
        return scanner.nextLine().trim();
    }




}
