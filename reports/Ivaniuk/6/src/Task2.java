package lab6;

public class Task2 {
    public static void main(String[] args){
        String bookName = "Java. Developer's guide";
        int grade = 10;

        Client client = new Client();

        client.buyBook(bookName);
        client.addToFavourite(bookName);
        client.appreciateBook(bookName,grade);

        System.out.println();
        client.upgradeToStandardAccount();
        client.buyBook(bookName);
        client.addToFavourite(bookName);
        client.appreciateBook(bookName,grade);

        System.out.println();
        client.upgradeToPremiumAccount();
        client.buyBook(bookName);
        client.addToFavourite(bookName);
        client.appreciateBook(bookName,grade);

    }
}


//паттерн Декоратор
interface IAccount{
    void buyBook(String bookName);
    void addToFavourite(String bookName);
    void appreciateBook(String bookName,int grade);
}

class BasicAccount implements IAccount{
    private String accountType;

    BasicAccount(){
        this.accountType = "Базовый аккаунт";
    }
    @Override
    public void buyBook(String bookName) {
        System.out.println(String.format("Вы купили книгу %s",bookName));
    }

    @Override
    public void addToFavourite(String bookName) {
        System.out.println("Вы не можете добавить в избранное через базовый аккаунт.");
    }

    @Override
    public void appreciateBook(String bookName, int grade) {
        System.out.println("Вы не можете оценить книгу через базовый аккаунт.");
    }
}

abstract class AccountDecorator implements IAccount{
    protected IAccount decoratedAccount;
    protected String accountType;

    public AccountDecorator(IAccount decoratedAccount) {
        this.decoratedAccount = decoratedAccount;
    }

    @Override
    public void buyBook(String bookName) {
        this.decoratedAccount.buyBook(bookName);
    }

    @Override
    public void addToFavourite(String bookName) {
        this.decoratedAccount.addToFavourite(bookName);
    }

    @Override
    public void appreciateBook(String bookName, int grade) {
        this.decoratedAccount.appreciateBook(bookName,grade);
    }
}

class StandardAccount extends AccountDecorator{

    public StandardAccount(IAccount decoratedAccount) {
        super(decoratedAccount);
        this.accountType = "Стандартный аккаунт";
    }

    @Override
    public void buyBook(String bookName) {
        System.out.println(String.format("Вы купили книгу %s",bookName));
    }

    @Override
    public void addToFavourite(String bookName) {
        System.out.println(String.format("Вы добавили  книгу %s в избранное.",bookName));
    }

    @Override
    public void appreciateBook(String bookName, int grade) {
        System.out.println("Вы не можете оценить книгу через стандартный аккаунт.");
    }
}

class PremiumAccount extends AccountDecorator{

    public PremiumAccount(IAccount decoratedAccount) {
        super(decoratedAccount);
        this.accountType = "Премиум аккаунт";
    }

    @Override
    public void buyBook(String bookName) {
        System.out.println(String.format("Вы купили книгу %s",bookName));
    }

    @Override
    public void addToFavourite(String bookName) {
        System.out.println(String.format("Вы добавили  книгу %s в избранное.",bookName));
    }

    @Override
    public void appreciateBook(String bookName, int grade) {
        System.out.println(String.format("Вы оценили книгу %s на оценку %d.",bookName,grade));
    }
}

class Client{
    private IAccount accountType;

    Client(){
        this.accountType = new BasicAccount();
    }

    public void upgradeToStandardAccount(){
        System.out.println("Повышение учетной записи до стандартного уровня...");
        this.accountType = new StandardAccount(this.accountType);
        System.out.println("Ваша учетная запись успешно обновлена до стандартного уровня!");
    }

    public void upgradeToPremiumAccount(){
        System.out.println("Повышение учетной записи до премиум уровня...");
        this.accountType = new PremiumAccount(this.accountType);
        System.out.println("Поздравляем! Ваша учетная запись теперь премиум!");
    }

    public void addToFavourite(String bookName){
         this.accountType.addToFavourite(bookName);
    }

    public void buyBook(String bookName){
         this.accountType.buyBook(bookName);
    }

    public void appreciateBook(String bookName, int grade){
         this.accountType.appreciateBook(bookName,grade);
    }
}
