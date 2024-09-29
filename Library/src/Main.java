import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	String nim, inputId1, inputId2, inputJud, name, yesno;
	int choice;

	ArrayList<Books> collection = new ArrayList<>();
	ArrayList<Pinjaman> pinjaman = new ArrayList<>();

	public Main() {
		header();
		name();
		user();

		do {
			System.out.println("Welcome to Libros, " + name + "!");
			System.out.println("================================");
			menu();
			try {
				choice = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Input must be an INTEGER!");
			}
			scan.nextLine();

			if (collection.isEmpty()) {

				Books B1 = new Books("22", "The Fire", "John", "2002", "Available");
				collection.add(B1);

				Books B2 = new Books("14", "The Ice", "Bob", "1988", "Available");
				collection.add(B2);

				Books B3 = new Books("89", "The Water", "Kain", "2023", "Available");
				collection.add(B3);

				Books B4 = new Books("10", "The Earth", "Mura", "1800", "Not Available");
				collection.add(B4);
			}

			switch (choice) {
			case 1:
				System.out.println("List of All Books");
				view2();

				for (int i = 0; i < collection.size(); i++) {
					System.out.printf("%s%15s%15s%15s%15s", collection.get(i).getId(), collection.get(i).getJudul(),
							collection.get(i).getPenulis(), collection.get(i).getTahunPublikasi(),
							collection.get(i).getStatus() + "\n");
					System.out.println("---------------------------------------------------------------");
				}
				System.out.println("Press ENTER to CONTINUE");
				scan.nextLine();

				break;

			case 2:
				System.out.println("List of Available Books");
				view2();

				for (int i = 0; i < collection.size(); i++) {
					if (collection.get(i).getStatus() == "Available") {
						System.out.printf("%s%15s%15s%15s%15s", collection.get(i).getId(), collection.get(i).getJudul(),
								collection.get(i).getPenulis(), collection.get(i).getTahunPublikasi(),
								collection.get(i).getStatus() + "\n");
						System.out.println("---------------------------------------------------------------");
					}

				}

				do {
					System.out.print("Enter Book Id: ");
					inputId1 = scan.nextLine();
				} while (!inputId1.equals(collection.get(0).getId()) && !inputId1.equals(collection.get(1).getId())
						&& !inputId1.equals(collection.get(2).getId()));

				for (int i = 0; i < collection.size(); i++) {

					if (collection.get(i).getId().equals(inputId1)) {
						System.out.println("============================================");
						System.out.println("Title: " + collection.get(i).getJudul());
						System.out.println("Author: " + collection.get(i).getPenulis());
						System.out.println("Year: " + collection.get(i).getTahunPublikasi());
						System.out.println("============================================");
						do {
							System.out.print("Are you sure you want to borrow this? [Yes | No] (Case Insensitive): ");
							yesno = scan.nextLine();
						} while (!yesno.equalsIgnoreCase("Yes") && !yesno.equalsIgnoreCase("No"));

						if (yesno.equalsIgnoreCase("yes")) {
							collection.set(i,
									new Books(collection.get(i).getId(), collection.get(i).getJudul(),
											collection.get(i).getPenulis(), collection.get(i).getTahunPublikasi(),
											"Not Available"));

							pinjaman.add(new Pinjaman(collection.get(i).getId(), collection.get(i).getJudul(),
									collection.get(i).getPenulis(), collection.get(i).getTahunPublikasi()));
							System.out.println("Books Borrowed SUCCESFULLY!");
						} else if (yesno.equalsIgnoreCase("no")) {
							System.out.println("Books Borrowed FAILED!");
						}

					}

				}

				System.out.println("Press ENTER to CONTINUE");
				scan.nextLine();
				break;

			case 3:
				System.out.println("Borrowed Books List");

				if (pinjaman.isEmpty()) {
					System.out.println("===================");
					System.out.println("No Borrowed Books");
					System.out.println("Press ENTER to CONTINUE");
					scan.nextLine();
				} else {
					view1();
					for (int i = 0; i < pinjaman.size(); i++) {
						System.out.printf("%s%15s%15s%15s", pinjaman.get(i).getId(), pinjaman.get(i).getJudul(),
								pinjaman.get(i).getPenulis(), pinjaman.get(i).getTahunPublikasi() + "\n");
						System.out.println("---------------------------------------------------");
					}

					do {
						System.out.print("Enter Book Id: ");
						inputId2 = scan.nextLine();
					} while (!inputId2.equals(collection.get(0).getId()) && !inputId2.equals(collection.get(1).getId())
							&& !inputId2.equals(collection.get(2).getId()));

					for (int i = 0; i < collection.size(); i++) {
						if (collection.get(i).getId().equals(inputId2)) {
							System.out.println("============================================");
							System.out.println("Title: " + collection.get(i).getJudul());
							System.out.println("Author: " + collection.get(i).getPenulis());
							System.out.println("Year: " + collection.get(i).getTahunPublikasi());
							System.out.println("============================================");

							collection.set(i,
									new Books(collection.get(i).getId(), collection.get(i).getJudul(),
											collection.get(i).getPenulis(), collection.get(i).getTahunPublikasi(),
											"Available"));
						}
					}
					for (int i = 0; i < pinjaman.size(); i++) {
						if (pinjaman.get(i).getId().equals(inputId2)) {
							pinjaman.remove(i);
							System.out.println("Book Returned SUCCESFULLY!");
						}
					}

					System.out.println("Press ENTER to CONTINUE");
					scan.nextLine();
				}

				break;

			case 4:
				System.out.println("\nBorrowed Books List");

				if (pinjaman.isEmpty()) {
					System.out.println("===================");
					System.out.println("No Borrowed Books");
					System.out.println("Press ENTER to CONTINUE");
					scan.nextLine();
				} else {
					view1();
					for (int i = 0; i < pinjaman.size(); i++) {
						System.out.printf("%s%15s%15s%15s", pinjaman.get(i).getId(), pinjaman.get(i).getJudul(),
								pinjaman.get(i).getPenulis(), pinjaman.get(i).getTahunPublikasi() + "\n");
						System.out.println("---------------------------------------------------");
					}

					System.out.println("Press ENTER to CONTINUE");
					scan.nextLine();
					break;

				}

			}

		} while (choice != 5);
		System.out.println("Thank you for using Libros!");

	}

	public static void main(String[] args) {
		new Main();

	}

	// Method
	public void header() {
		System.out.println("Welcome to Libros");
		System.out.println("==================");

	}

	public void menu() {
		System.out.println("1. All Books");
		System.out.println("2. Borrow Book");
		System.out.println("3. Return Book");
		System.out.println("4. List of Borrowed Books");
		System.out.println("5. Exit");
		System.out.printf(">> ");
	}

	public void name() {
		do {
			System.out.printf("Name: ");
			name = scan.nextLine();
		} while (name.length() < 3);
	}

	public void user() {

		do {
			System.out.printf("NIM: ");
			nim = scan.nextLine();
		} while (nim.length() != 10);
		System.out.println(" ");
	}

	public void view1() {
		System.out.println("===================================================");
		System.out.printf("%s%15s%15s%15s", "ID", "Title", "Author", "Year" + "\n");
		System.out.println("===================================================");
	}

	public void view2() {
		System.out.println("===============================================================");
		System.out.printf("%s%15s%15s%15s%15s", "ID", "Title", "Author", "Year", "Status" + "\n");
		System.out.println("===============================================================");
	}

}
