package exam;

public class ApplicationContextMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = ApplicationContext.getInstance();
        ApplicationContext context2 = ApplicationContext.getInstance();

        if(context == context2){
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        Book book = (Book) context.getBean("book1");
        book.setPrice(5000);
        book.setTitle("java is funny");

        System.out.println(book.getPrice());
        System.out.println(book.getTitle());

        Book book2 = (Book) context.getBean("book1");

        if(book == book2){
            System.out.println(true);
        } else {
            System.out.println(false);
        }


    }
}
