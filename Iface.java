import java.io.*;
import java.util.Scanner;

public class Iface
{
    static int QuantityOfUsers = 0;
    
    static String[] username = new String[100]; 
    static String[] password = new String[100];
    static boolean[] communitiesOnwers = new boolean[100];
            
    static String user; 
    static String pass;
    static String historic = "\0";
    static String message;
    static String communityName;
    static String communityDescription;
    
    static boolean available; // to see if the username is already being used//
    static boolean sucess; // to see if your logged with sucess or if you changed your username or your password with sucess//
    static boolean existent = false;
    static boolean correct = false;
    
    static int WhosLogged; 
    static int option = 0;
    static int alteration;
    static int other;
        
    static boolean[][] matrixOfFriends = new boolean[100][100];
    
    static String[][] matrixOfMessages = new String[100][100];

    static String[][] matrixOfCommunitiesCharacteristics = new String[100][2];

    static boolean[][] matrixOfCommunitiesMembers = new boolean[100][100];

    static boolean[][] matrixOfCommunitiesRequests = new boolean[100][100];
    
    static Scanner input = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args)
    {
        while (option != 9)
        {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            System.out.println("Welcome to Iface!\n");
            
            System.out.println("(0) To create an account;");
            System.out.println("(1) To Login;\n");

            option = input.nextInt();

            if (option == 0)
            {
                CreateAccount();
            }

            if (option == 1)
            {
                Login();
                
                int logged = 1;

                while (logged == 1)
                {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                    System.out.println("What would you like to do?;\n");
                
                    System.out.println("(1) To edit your profile;");
                    System.out.println("(2) To make friends;");
                    System.out.println("(3) To send messages to other users;");
                    System.out.println("(4) To create a community;");
                    System.out.println("(5) To become part of a community;");
                    System.out.println("(6) To recover information about your activity in Iface;");
                    System.out.println("(7) To delete your account;");
                    System.out.println("(8) To Logout;\n");

                    option = input.nextInt();

                    if (option == 1) EditProfile();
                    if (option == 2) MakeFriends(); 
                    if (option == 3) InteractThoughMessages();
                    if (option == 4) CreateCommunity();
                    if (option == 5) JoinOrAdmCommunity();
                    if (option == 6) RecoverInformation();
                    if (option == 7) DeleteAccount();
                    if (option == 8) 
                    {
                        logged = 0;
                        //Logout();
                    }
                    else
                    {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("(0) If would like to Logout;\n");
                        System.out.println("(1) If would like to stay logged;\n");

                        logged = input.nextInt();
                    }
                    if (option == 0 || option > 8)
                    {
                        System.out.println("This opition does not refer to one of our functions!\nPlease try again!\n");
                    }
                }
            }
        }
    }

    public static void CreateAccount()
    {
        sucess = false; 

        while (!sucess)
        {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            System.out.println("Please enter the name you would like as your username:");
            user = input.next();
                
            available = true;

            for (int i = 0; i < QuantityOfUsers; i++)
            {
                if(user.equals(username[i]) == true)
                {
                    available = false;
                    break;
                }
            }
            if (available)
            {
                username[QuantityOfUsers] = user;
                System.out.println("Please enter what you would like to be your password:");
                password[QuantityOfUsers] = input.next();
                sucess = true;
                QuantityOfUsers++;
            }
            else
            {
                System.out.println("Sorry, This username is not available!");
            } 
        }
        System.out.println("Account created with sucess!");
            
        // System.out.format("%s%n", username[QuantityOfUsers - 1]);
        // System.out.format("%s%n", password[QuantityOfUsers - 1]);
    }

    public static void Login()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Please enter your username:");
        user = input.next();
        
        while (!existent)
        {
            for (int i = 0; i < QuantityOfUsers; i++)
            {
                if(user.equals(username[i]) == true)
                {
                    WhosLogged = i;
                    existent = true;
                    break;
                }
            }
            if (!existent) 
            {
                System.out.println("There is no account with this user name!");
                System.out.println("Please enter your username:");
                user = input.next();
            }
        }

        System.out.println("Please enter your password:");
        pass = input.next();

        while (!correct)
        { 
            if(pass.equals(password[WhosLogged]) == false) 
            {
                System.out.println("Wrong password!");
                System.out.println("Please enter your password:");
                pass = input.next();
            }
            else 
            {
                correct = true;
            }
        }
    }

    public static void EditProfile()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("What would you like to alter?");
        System.out.println("(1) My username!");
        System.out.println("(2) My password!");

        alteration = input.nextInt();

        if (alteration == 1)
        {
            sucess = false;

            while (!sucess)
            {
                System.out.println("Please enter the name you would like to be your new username:");
                user = input.next();

                available = true;

                for (int i = 0; i < QuantityOfUsers; i++)
                {
                    if(user.equals(username[i]) == true)
                    {
                        WhosLogged = i;
                        available = false;
                        break;
                    }
                }
                if (available) 
                {
                    username[WhosLogged] = user;
                    sucess = true;
                    System.out.println("Your username has been altered with sucess!"); 
                }
                else System.out.println("Sorry, This username is not available!");
               
            }
        }
        if (alteration == 2)
        {
            System.out.println("Please enter what you would like to be your new password:");
            password[WhosLogged] = input.next();
            System.out.println("Your password has been altered with sucess!");
        }
    }

    public static void MakeFriends()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("Choose what you would like to do");
        System.out.println("(1) Send a friend solicitation;\n");
        System.out.println("(2) See notifications;\n");

        option = input.nextInt();

        if (option == 1)
        {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            System.out.println("Please enter the name of the user you would like to send a friendship solicitation:");
            user = input.next();

            sucess = false;

            for (int i = 0; i < QuantityOfUsers; i++)
            {
                if(user.equals(username[i]) == true)
                {
                    matrixOfFriends[WhosLogged][i] = true; 
                    sucess = true;
                    break;
                }
            }

            if (sucess) System.out.println("The solicitation has been sent!");
            else System.out.println("This user does not exist");
        }

        if (option == 2)
        {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            for (int i = 0; i < QuantityOfUsers; i++)
            {
                if (matrixOfFriends[i][WhosLogged] == true)
                {
                    System.out.printf("You have a friendship solitation from %s", username[i]);
                    System.out.println("(1) If would you like to accept it");
                    System.out.println("(2) If would you like to deny it");

                    int want = input.nextInt();

                    if (want == 1) 
                    {
                        matrixOfFriends[WhosLogged][i] = true;
                        System.out.println("Solicitation accepted!");
                    }
                    if (want == 2) 
                    {
                        matrixOfFriends[i][WhosLogged] = false;
                        System.out.println("Solicitation denyed!");
                    }
                }
            }
        }
    }

    public static void InteractThoughMessages()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("Please enter the name of the user you would like to send a message:");
        user = input.next();

        sucess = false;

        for (int i = 0; i < QuantityOfUsers; i++)
        {
            if(user.equals(username[i]) == true)
            {
                other = i;
                sucess = true;
                break;
            }
        }

        if (sucess) 
        {
            if (matrixOfMessages[WhosLogged][other] != null)
            { 
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.printf("%s", matrixOfMessages[WhosLogged][other]);
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }

            System.out.println("What message would you like to send?");

            input.nextLine();

            message = input.nextLine();

            if (historic != "\0") 
            {
                historic = matrixOfMessages[WhosLogged][other] + "\n";
                matrixOfMessages[WhosLogged][other] = historic.concat(username[WhosLogged] + ": " + message);
                matrixOfMessages[other][WhosLogged] = matrixOfMessages[WhosLogged][other];
            }
            else
            {
                matrixOfMessages[WhosLogged][other] = username[WhosLogged] + ": " + message;
                matrixOfMessages[other][WhosLogged] = matrixOfMessages[WhosLogged][other];
                historic = matrixOfMessages[WhosLogged][other];
            }

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.printf("%s", matrixOfMessages[WhosLogged][other]);
        }
        else 
        {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("This user does not exist");
        }
    }

    public static void CreateCommunity()
    {
        sucess = false;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("What is the name you would like to give to your community?");

        communityName = input.next();

        while (!sucess)
        {
            existent = false;

            for (int i = 0; i < QuantityOfUsers; i++)
            {
                if(communityName.equals(matrixOfCommunitiesCharacteristics[i][0]) == true)
                {
                    existent = true;

                    System.out.println("There is already a community with this name!");
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("What is the name you would like to give to your community?");

                    communityName = input.next();

                    break;
                }
            }

            if (!existent) 
            {
                sucess = true;
                matrixOfCommunitiesCharacteristics[WhosLogged][0] = communityName;
            }
        }
        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("What is the description of your community?");

        communityDescription = input.next();

        matrixOfCommunitiesCharacteristics[WhosLogged][1] = communityDescription;

        //System.out.printf("%s\n%s",matrixOfCommunitiesCharacteristics[WhosLogged][0] ,matrixOfCommunitiesCharacteristics[WhosLogged][1]);

        //matrixOfCommunitiesMembers[WhosLogged][WhosLogged] = true;
        communitiesOnwers[WhosLogged] = true;

        System.out.print(communitiesOnwers[WhosLogged]);
    }

    public static void JoinOrAdmCommunity()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("Choose what you would like to do");
        System.out.println("(1) To administrate your community;\n");
        System.out.println("(2) To Join other communities;\n");

        option = input.nextInt();

        if (option == 1)
        {
            //if (!(matrixOfCommunitiesMembers[WhosLogged][WhosLogged] == true)) System.out.println("Your not a owner of a community yet!");

            System.out.print(communitiesOnwers[WhosLogged]);

            if (!(communitiesOnwers[WhosLogged] == true)) System.out.println("Your not a owner of a community yet!");
            else
            {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                System.out.println("Choose what you would like to do");
                System.out.println("(1) To edit information about the community;\n");
                System.out.println("(2) To see the requests to enter your community;\n");
    
                option = input.nextInt();
    
                if (option == 1)
                {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                    System.out.println("What would you like to alter?");
                    System.out.println("(1) The community name!");
                    System.out.println("(2) The community description!");
    
                    alteration = input.nextInt();
    
                    if (alteration == 1)
                    {
                        System.out.println("What name you would like as your new community name?");
    
                        communityName = input.next();
    
                        existent = false;

                        for (int i = 0; i < QuantityOfUsers; i++)
                        {
                            if(communityName.equals(matrixOfCommunitiesCharacteristics[i][0]) == true)
                            {
                                existent = true;
                                System.out.println("There is already a community with this name!");
                                break;
                            }
                        }
                        if (!existent)
                        {
                            matrixOfCommunitiesCharacteristics[WhosLogged][0] = communityName;

                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                            System.out.println("The community name has been changed!");
                        }
                    }
                    if (alteration == 2)
                    {
                        System.out.println("What would you like as your new description?");
    
                        communityDescription = input.nextLine();
    
                        existent = false;

                        for (int i = 0; i < QuantityOfUsers; i++)
                        {
                            if(communityDescription.equals(matrixOfCommunitiesCharacteristics[i][1]) == true)
                            {
                                existent = true;
                                System.out.println("There is already a community with this description!");
                                break;
                            }
                        }

                        if (!existent)
                        {
                            matrixOfCommunitiesCharacteristics[WhosLogged][1] = communityDescription;
                            System.out.println("The description has been changed!");
                        }
                    }
                    option = 1;
                }
                if (option == 2)
                {
                    existent = false;

                    for (int i = 0; i < QuantityOfUsers; i++)
                    { 
                        if (matrixOfCommunitiesRequests[WhosLogged][i] == true && matrixOfCommunitiesMembers[WhosLogged][i] == false)
                        {
                            existent = true;
                            System.out.printf("%d sent a request!\n", username[i]);
                            System.out.println("would you like to:");
                            System.out.println("(1) Let him in the community!");
                            System.out.println("(2) Deny the request!");

                            option = input.nextInt();

                            if (option == 1)
                            {
                                matrixOfCommunitiesRequests[WhosLogged][i] = false;
                                matrixOfCommunitiesMembers[WhosLogged][i] = true;
                            }
                            if (option == 2)
                            {
                                matrixOfCommunitiesRequests[WhosLogged][i] = false;
                            }
                        }
                    }
                    if (!existent) System.out.println("There is not any requests at the moment!");
                }
            }
            option = 1;
        }
        if (option == 2)
        {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            System.out.println("What is the community name you would like to enter?");

            communityName = input.next();

            existent = false;

            for (int i = 0; i < QuantityOfUsers; i++)
            {
                if(communityName.equals(matrixOfCommunitiesCharacteristics[i][0]) == true)
                {
                    matrixOfCommunitiesRequests[i][WhosLogged] = true;
                    System.out.println("Your request to enter has been sent!");
                    existent = true;
                }
            }
            if (!existent)
            {
                System.out.println("There is not a community with this name!");
            }
        }
    }

    public static void RecoverInformation()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("What information would you like to recover from your account?");
        System.out.println("(1) Your username");
        System.out.println("(2) your password");
        System.out.println("(3) Your community name");
        System.out.println("(4) Your community description");
        System.out.println("(5) Your friends");
        System.out.println("(6) Your messages");

        option = input.nextInt();

        if (option == 1)
        {
            System.out.printf("Your username: %s\n", username[WhosLogged]);
        }
        if (option == 2)
        {
            System.out.printf("Your password: %s\n", password[WhosLogged]);
        }
        if (option == 3)
        {
            if (matrixOfCommunitiesCharacteristics[WhosLogged][0] != null)
            {
                System.out.printf("Your community description: %s\n", matrixOfCommunitiesCharacteristics[WhosLogged][0]);
            }
            else
            {
                System.out.println("You do not have a community");
            }
        }
        if (option == 4)
        {
            if (matrixOfCommunitiesCharacteristics[WhosLogged][1] != null)
            {
                System.out.printf("Your community description: %s\n", matrixOfCommunitiesCharacteristics[WhosLogged][1]);
            }
            else
            {
                System.out.println("You do not have a community");
            }
        }
        if (option == 5)
        {
            int QuantityOfFriends = 0;
            
            for (int i = 0; i < QuantityOfUsers; i++)
            {
                if(matrixOfFriends[i][WhosLogged] == true && matrixOfFriends[WhosLogged][i] == true)
                {
                    QuantityOfFriends++;
                }
            }
            if (QuantityOfFriends == 0) System.out.println("You have no friends");
            else 
            {
                System.out.printf("You have %d friends!", QuantityOfFriends);

                System.out.println("Here is a list of them:");

                for (int i = 0; i < QuantityOfUsers; i++)
                {
                    if(matrixOfFriends[i][WhosLogged] == true && matrixOfFriends[WhosLogged][i] == true)
                    {
                        System.out.printf("%d;\n", QuantityOfFriends);
                    }
                }
            }
        }
        if (option == 6)
        {
            sucess = false;

            while (!sucess)
            {
                System.out.println("What user you would like to recorver the messages?");
                user = input.next();

                existent = false;

                int i;

                for (i = 0; i < QuantityOfUsers; i++)
                {
                    if(user.equals(username[i]) == true)
                    {
                        existent = true;
                        break;
                    }
                }
                if (existent) 
                {
                    sucess = true;
                    if (matrixOfMessages[WhosLogged][i] != null)
                    {
                        System.out.printf("This is your convesation with %s:\n%s\n", username[i], matrixOfMessages[WhosLogged][i]); 
                    }
                    else System.out.printf("You do not have a convertation with %s!", username[i]);
                }
                else System.out.println("Sorry, This username does not exist!");
            }
        }
    }

    public static void DeleteAccount()
    {
        username[WhosLogged] = null;
        password[WhosLogged] = null;

        for (i = 0; i < QuantityOfUsers; i++)
        {
            if(matrixOfFriends[WhosLogged][i] = true)
            {
                matrixOfFriends[WhosLogged][i] = false;
            }
            if(matrixOfFriends[i][WhosLogged] = true)
            {
                matrixOfFriends[i][WhosLogged] = false;
            }
        }

        for (i = 0; i < QuantityOfUsers; i++)
        {
            if(matrixOfMessages[WhosLogged][i] != null )
            {
                matrixOfMessages[WhosLogged][i] = null;
            }
            if(matrixOfMessages[i][WhosLogged] != null )
            {
                matrixOfMessages[i][WhosLogged] = null;
            }
        }

        if (communitiesOnwers[WhosLogged] == true)
        {
            communitiesOnwers[WhosLogged] = false;
            matrixOfCommunitiesCharacteristics[WhosLogged][0] = null; 
            matrixOfCommunitiesCharacteristics[WhosLogged][1] = null;

            for (i = 0; i < QuantityOfUsers; i++)
            {
                if(matrixOfCommunitiesMembers[WhosLogged][i] = true)
                {
                    matrixOfCommunitiesMembers[WhosLogged][i] = false;
                }
                if(matrixOfCommunitiesMembers[i][WhosLogged] = true)
                {
                    matrixOfCommunitiesMembers[i][WhosLogged] = false;
                }
            }
        }
    }
}