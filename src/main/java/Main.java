import controllers.PeopleService;
import models.People;
import view.ConsoleView;

public class Main {

	public static void main(String[] args) {
		ConsoleView console = new ConsoleView();

		Integer userChoice = console.getDeservedOperation();
		
		PeopleService pService = new PeopleService();

		if (userChoice.equals(1)) {
			People people = console.getPeopleObject();
			pService.savePeople(people);
			System.out.println("Suscessful saved!");
		} else if (userChoice > 1) {
			Integer id = console.getPeopleId();
			if (userChoice.equals(2)) {
				pService.deletePeople(id);
				System.out.println("Sucessful deleted!");
			} else if (userChoice.equals(3)) {
				System.out.println(pService.findPeople(id));
			}
		}

		pService.closeEntityManagerFactory();

	}
}
