package eu.deltasource.library;

import eu.deltasource.library.controllers.BookController;
import eu.deltasource.library.controllers.LoginController;
import eu.deltasource.library.controllers.UserBooksController;
import eu.deltasource.library.controllers.UserController;
import eu.deltasource.library.entities.EBookInfo;
import eu.deltasource.library.entities.PaperBookInfo;
import eu.deltasource.library.entities.UserAccount;
import eu.deltasource.library.util.BookFactory;
import eu.deltasource.library.util.UserAccountFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryDemoExecutor {

    @Autowired
    private BookController bookController;
    @Autowired
    private UserController userController;
    @Autowired
    private LoginController loginController;
    @Autowired
    private UserBooksController userBooksController;

    public void exec() {
        //init objects
        PaperBookInfo paperBookInfoToAddToRepo = BookFactory.createPaperBookInfo(1);
        EBookInfo eBookInfoToAddToRepo = BookFactory.createEBookInfo();
        UserAccount userAccountToAddToRepo = UserAccountFactory.createUserAccount("Username", "Password");
        UserAccount userAccountToAddToRepo2 = UserAccountFactory.createUserAccount("Username2", "Password");
        bookController.addNewEBook(eBookInfoToAddToRepo);
//        bookController.addNewPaperBook(paperBookInfoToAddToRepo);
        userController.addNewUserAccount(userAccountToAddToRepo);
        userController.addNewUserAccount(userAccountToAddToRepo2);

        //demo cases
        loginController.logIn("Username", "Password");
        System.out.println(userBooksController.tryToBorrowBook(paperBookInfoToAddToRepo));

//        loginController.logOut();
//        loginController.logIn("Username2", "Password");
//
//        System.out.println(userBooksController.tryToBorrowBook(paperBookInfoToAddToRepo));
//
//        loginController.logOut();
//        loginController.logIn("Username", "Password");
//
//        userBooksController.returnBookByIsbn("123isbn");
//
//        loginController.logOut();
//        loginController.logIn("Username2", "Password");
//
//        System.out.println(userBooksController.tryToBorrowBook(paperBookInfoToAddToRepo));
//        System.out.println(userBooksController.findBorrowedBookByIsbn("123isbn"));
//
//        loginController.logOut();
//        loginController.logIn("Username", "Password");
//
//        System.out.println(userBooksController.tryToBorrowBook(paperBookInfoToAddToRepo));
//        System.out.println(userBooksController.tryToBorrowBook(paperBookInfoToAddToRepo));
//        System.out.println(userBooksController.tryToBorrowBook(paperBookInfoToAddToRepo));

        bookController.addNewPaperBook(BookFactory.createPaperBookInfo("1", "The Premonition: A Pandemic Story",
                "Fortunately, we are still a nation of skeptics. Fortunately, there are those among us who study pandemics and are willing to look unflinchingly at worst-case scenarios. Michael Lewis’s taut and brilliant nonfiction thriller pits a band of medical visionaries against the wall of ignorance that was the official response of the Trump administration to the outbreak of COVID-19.",
                "https://images-na.ssl-images-amazon.com/images/I/41+2DiWeWAS._SX345_BO1,204,203,200_.jpg"));
        bookController.addNewPaperBook(BookFactory.createPaperBookInfo("2", "Adulting: How to Become a Grown-up in 468 Easy(ish) Steps",
                "If you graduated from college but still feel like a student . . . if you wear a business suit to job interviews but pajamas to the grocery store . . . if you have your own apartment but no idea how to cook or clean . . . it's OK. But it doesn't have to be this way.",
                "https://images-na.ssl-images-amazon.com/images/I/510VK8Q1dbL._SX328_BO1,204,203,200_.jpg"));
        bookController.addNewPaperBook(BookFactory.createPaperBookInfo("3", "Ariadne: A Novel",
                "Ariadne, Princess of Crete, grows up greeting the dawn from her beautiful dancing floor and listening to her nursemaid’s stories of gods and heroes. But beneath her golden palace echo the ever-present hoofbeats of her brother, the Minotaur, a monster who demands blood sacrifice.",
                "https://images-na.ssl-images-amazon.com/images/I/41AvaBmddFL._SX329_BO1,204,203,200_.jpg"));
        bookController.addNewPaperBook(BookFactory.createPaperBookInfo("4", "Impostor Syndrome: A Novel",
                "A sharp and prescient novel about women in the workplace, the power of Big Tech, and the looming threat of foreign espionage from Kathy Wang, “a skilled satirist of the northern California dream” (Harper’s Bazaar)",
                "https://images-na.ssl-images-amazon.com/images/I/41hwpqxplYL._SX331_BO1,204,203,200_.jpg"));
        bookController.addNewPaperBook(BookFactory.createPaperBookInfo("8", "The Premonition: A Pandemic Story",
                "Fortunately, we are still a nation of skeptics. Fortunately, there are those among us who study pandemics and are willing to look unflinchingly at worst-case scenarios. Michael Lewis’s taut and brilliant nonfiction thriller pits a band of medical visionaries against the wall of ignorance that was the official response of the Trump administration to the outbreak of COVID-19.",
                "https://images-na.ssl-images-amazon.com/images/I/41+2DiWeWAS._SX345_BO1,204,203,200_.jpg"));
        bookController.addNewPaperBook(BookFactory.createPaperBookInfo("5", "Adulting: How to Become a Grown-up in 468 Easy(ish) Steps",
                "If you graduated from college but still feel like a student . . . if you wear a business suit to job interviews but pajamas to the grocery store . . . if you have your own apartment but no idea how to cook or clean . . . it's OK. But it doesn't have to be this way.",
                "https://images-na.ssl-images-amazon.com/images/I/41+2DiWeWAS._SX345_BO1,204,203,200_.jpg"));
        bookController.addNewPaperBook(BookFactory.createPaperBookInfo("6", "Ariadne: A Novel",
                "Ariadne, Princess of Crete, grows up greeting the dawn from her beautiful dancing floor and listening to her nursemaid’s stories of gods and heroes. But beneath her golden palace echo the ever-present hoofbeats of her brother, the Minotaur, a monster who demands blood sacrifice.",
                "https://images-na.ssl-images-amazon.com/images/I/41AvaBmddFL._SX329_BO1,204,203,200_.jpg"));
        bookController.addNewPaperBook(BookFactory.createPaperBookInfo("7", "Impostor Syndrome: A Novel",
                "A sharp and prescient novel about women in the workplace, the power of Big Tech, and the looming threat of foreign espionage from Kathy Wang, “a skilled satirist of the northern California dream” (Harper’s Bazaar)",
                "https://images-na.ssl-images-amazon.com/images/I/41hwpqxplYL._SX331_BO1,204,203,200_.jpg"));

    }
}
