import java.util.Scanner;

public class HibernateRunner {

    public static void main(String[] args) {
        TypeService obiect1 = TypeService.getInstance();
        ProjectService obiect2 = ProjectService.getInstance();
        Type type1 = new Type();
        type1.nume = "Button";
        obiect1.createType(type1);

        System.out.println();
        System.out.println("*** ***Hello to my project*** ***  \n            ***Welcome!***       ");
        System.out.println("Please make a choice from the following: ");
        System.out.println();
        System.out.println("1 - View Project");
        System.out.println("2 - Add Project");
        System.out.println("3 - Exit Program");
        System.out.println();
        System.out.println("Types of options: ");
        Scanner scanchoice = new Scanner(System.in);
        int choiceEntry;

        do {
            System.out.println("Enter: " + "View Project" + "/" + "Add Project" + "/" + "Exit Program");
            choiceEntry = scanchoice.nextInt();

            switch (choiceEntry) {
                case 1:
                    System.out.println("View Project");
                    Scanner viewProject = new Scanner(System.in);
                    //System.out.println());
                    System.out.println("Enter project id");
                    int projectId = viewProject.nextInt();
                    Project project = ProjectService.getInstance().getProject(projectId);
                    System.out.println("Project is :" + project);
                    break;
                case 2:
                    Scanner addProject = new Scanner(System.in);
                    int newChoice = addProject.nextInt();
                    switch (newChoice) {
                        case 1:
                            System.out.println("Enter project id" );
                            int project1Id = addProject.nextInt();
                            Project project1 = ProjectService.getInstance().getProject(project1Id);
                            System.out.println("Project is :" + project1);
                        case 2:
                            System.out.println("List all projects");
                            newChoice = scanchoice.nextInt();
                            Scanner userInput = new Scanner(System.in);

                           // ProjectService.getInstance().createProject(project1);
                            //System.out.println(ProjectService.(project1.(addProject.nextInt())));
                            break;
                        case 3:
                            System.out.println("Exit program");
                            return;
                        default:
                            System.out.println("Choice should be a value between 1 and 3");
                    }
            }
        }
        while (choiceEntry != 3);

        HibernateUtil.shutdown();
    }
}


