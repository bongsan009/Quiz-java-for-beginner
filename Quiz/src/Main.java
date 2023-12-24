import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question
{
    private String questionText;
    private List<String> answers;
    private int correctAnswer;

    //Constructor
    Question(){}

    //Params Constructor
    Question(String questionText, List<String> answers, int correctAnswer)
    {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    //Encapsulation
    public void setQuestionText(String questionText)
    {
        this.questionText = questionText;
    }

    public void setAnswers(List<String> answers)
    {
        this.answers = answers;
    }

    public void setCorrectAnswer(int correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText()
    {
        return this.questionText;
    }

    public List<String> getAnswers()
    {
        return this.answers;
    }

    public int getCorrectAnswer()
    {
        return this.correctAnswer;
    }
}

class User
{
    public static List<User> userList = new ArrayList<>();
    private String userName;
    private String password;

    User(){}

    User(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void register(Scanner in)
    {
        System.out.print("Enter username :: "); String username = in.nextLine();
        System.out.print("Enter password :: "); String password = in.nextLine();

        User newUser = new User(username, password);
        userList.add(newUser);
        System.out.println("Registration successfully.");
    }

    public void login(Scanner in)
    {
        System.out.print("Enter username :: "); String username = in.nextLine();
        System.out.print("Enter password :: "); String password = in.nextLine();

        for (User user : userList)
        {
            if (user.getUserName().equals(username) && user.getPassword().equals(password))
            {
                Main.startExam(user);
            }
        }
    }
}



public class Main {
    public static List<Question> questionList = new ArrayList<>();
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        User user = new User();

        boolean programOn = true;

        initializeQuestions();

        do {
            System.out.println("1). Register");
            System.out.println("2). Login");
            System.out.println("3). Exit");
            System.out.print("Choose the option above :: "); int userOpt = in.nextInt(); in.nextLine();

            switch (userOpt)
            {
                case 1:
                {
                    user.register(in);
                    break;
                }

                case 2:
                {
                    user.login(in);
                    break;
                }

                case 3:
                {
                    System.exit(0);
                }
            }

        }while (programOn);



    }

    public static void initializeQuestions()
    {
        List<String> list1 = new ArrayList<>();
        list1.add("Kotlin");
        list1.add("PHP and C#");
        list1.add("Python and JavaScript");
        list1.add("All the above");

        List<String> list2 = new ArrayList<>();
        list2.add("C++");
        list2.add("Objective-C");
        list2.add("Ada");
        list2.add("All the above");

        List<String> list3 = new ArrayList<>();
        list3.add("May 23, 1995");
        list3.add("July, 1994");
        list3.add("August, 2001");
        list3.add("September, 1983");

        List<String> list4 = new ArrayList<>();
        list4.add("Dennis Ritchie");
        list4.add("James Gosling");
        list4.add("Charles Babbage");
        list4.add("Guido van Rossum");

        Question question1 = new Question("Java influenced",list1,3);
        Question question2 = new Question("Java influenced by", list2, 3);
        Question question3 = new Question("Java first appeared in",list3,0);
        Question question4 = new Question("Java is designed by", list4,1);

        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
    }

    public static void startExam(User user)
    {
        int score = 0;
        System.out.println("Welcome >>> " + user.getUserName() + " to our Examination System...");
        for (int i = 0; i < questionList.size(); i++)
        {
            Question question = questionList.get(i);
            System.out.println("Question " + (i+1) + ": " + question.getQuestionText());

            for (int j = 0; j < question.getAnswers().size(); j++)
            {
                System.out.println((" " + (j+1) + ". "+ question.getAnswers().get(j)));
            }


            System.out.print("Choose the correct anwser :: "); int correctAnswer = in.nextInt();

            if (correctAnswer == question.getCorrectAnswer() + 1)
            {
                System.out.println("Correct.");
                score += 10;
            }else {
                System.out.println("Incorrect.");
            }
        }
        System.out.println(">>> Result <<<");
        System.out.println("The total scores :: " + score);
    }
}