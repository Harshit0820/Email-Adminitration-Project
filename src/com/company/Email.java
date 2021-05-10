package com.company;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private int defaultMailboxCapacity = 5000;
    private String alternateEmail;
    private String companySuffix = "mnccompany.com";

    //Constructor to use the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName.toUpperCase() + " " + this.lastName.toUpperCase());

        //Call a method asking for the department
        this.department = askDepartment();
        System.out.println("Department: " + this.department);

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);

        //Combine elements to generate email
        System.out.println("--------------------------------------\nYOUR EMAIL IS: " + this.firstName.toLowerCase()
                + "." + this.lastName.toLowerCase()
                + "@" + department + companySuffix + "\nPASSWORD IS: " + password
                + "\nWITH MAIL CAPACITY OF: " + this.defaultMailboxCapacity + " Mails");

        System.out.println("--------------------------------------");
        changePassword();

    }

    //Ask for department
    private String askDepartment() {
        System.out.println("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "accounting";
        } else {
            return "";
        }
    }

    //Generate random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }


    private void changePassword() {
        System.out.println("TO CHANGE PASSWORD PRESS 9 OR ANY NUMBER TO CONTINUE:");
        Scanner in = new Scanner(System.in);
        int pChange = in.nextInt();
        if (pChange == 9) {
            newPassword(defaultPasswordLength);

        }
    }

    public void newPassword(int length) {
        System.out.println("ENTER NEW PASSWORD (length 10 max) : ");
        Scanner np = new Scanner(System.in);
        int check = 0;
        while (check != 1){
            check = 0;
            String newPassword = np.next();
            if (newPassword.length() == length) {
                System.out.println("PASSWORD CHANGED SUCCESSFULLY\nNEW PASSWORD SET THAT IS: " + newPassword);
                check = 1;
            } else if (newPassword.length() < length) {
                System.out.println("PASSWORD IS SHORT.\nPLEASE ENTER PASSWORD AGAIN (length 10 max):");
            }else if (newPassword.length() > length){
                System.out.println("PASSWORD IS LONG.\nPLEASE ENTER PASSWORD AGAIN (length 10 max):");
            }
        }
    }
}
