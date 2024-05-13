package lab6;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Task1{
    public static void main(String[] args){
        MusicStore store = MusicStore.getInstance();
        addMusicItems(store);
        User user1 = new User("Dima");
        User user2 = new User("Kirill");
        User user3 = new User("Stas");

        user1.buyMusicItem(store,"Rock",new MusicItem("Numb", "Linkin Park"));
        System.out.println();
        user2.buyMusicItem(store,"Rock",new MusicItem("Numb", "Linkin Park"));
        System.out.println();
        user2.buyMusicItem(store,"Rock",new MusicItem("In the End", "Linkin Park"));
        System.out.println();
        user3.buyMusicItem(store,"Jazz",new MusicItem("Take Five", "Dave Brubeck"));
        System.out.println();
        store.displayMusicItems();
    }
    public static void addMusicItems(MusicStore store){
        store.addMusicItem("Rock", new MusicItem("Numb", "Linkin Park"), 1);
        store.addMusicItem("Rock", new MusicItem("In the End", "Linkin Park"), 15);
        store.addMusicItem("Rock", new MusicItem("Breaking the Habit", "Linkin Park"), 10);
        store.addMusicItem("Pop", new MusicItem("Shape of You", "Ed Sheeran"), 30);
        store.addMusicItem("Pop", new MusicItem("Someone Like You", "Adele"), 25);
        store.addMusicItem("Jazz", new MusicItem("Take Five", "Dave Brubeck"), 12);
        store.addMusicItem("Jazz", new MusicItem("So What", "Miles Davis"), 8);
    }
}

class MusicStore{
    private static MusicStore uniqueInstance;
    private Map<String, Map<MusicItem, Integer>> musicItemsMap;
    MusicStore(){
        this.musicItemsMap = new HashMap<>();
    }
    public static synchronized MusicStore getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new MusicStore();
        }
        return uniqueInstance;
    }

    public void addMusicItem(String category,MusicItem item, int quantity){
        this.musicItemsMap.computeIfAbsent(category,k->new HashMap<>()).put(item,quantity);
        //System.out.println("Товар добавлен в каталог.");
    }

    public boolean buyMusicItem(String category, MusicItem item) {
        if (!musicItemsMap.containsKey(category) || !musicItemsMap.get(category).containsKey(item) || musicItemsMap.get(category).get(item) <= 0) {
            System.out.println("Товар " + item.getTitle() + " - " + item.getArtist() + " отсутствует в наличии.");
            return false;
        }
        int remainingQuantity = musicItemsMap.get(category).get(item) - 1;
        musicItemsMap.get(category).put(item, remainingQuantity);
        System.out.println("Покупка товара " + item.getTitle() + " - " + item.getArtist() + ", Остаток: " + musicItemsMap.get(category).get(item));
        return true;
    }
    public void displayMusicItems() {
        System.out.println("В наличии:");
        for (Map.Entry<String, Map<MusicItem, Integer>> categoryEntry : musicItemsMap.entrySet()) {
            String category = categoryEntry.getKey();
            System.out.println("\tКатегория: " + category);
            for (Map.Entry<MusicItem, Integer> itemEntry : categoryEntry.getValue().entrySet()) {
                MusicItem item = itemEntry.getKey();
                int quantity = itemEntry.getValue();
                System.out.println("\t\t\tНазвание: " + item.getTitle() + ", Исполнитель: " + item.getArtist() + ", Количесвто: " + quantity);
            }
        }
    }
}

class MusicItem{
    private String title;
    private String artist;

    public MusicItem(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicItem musicItem = (MusicItem) o;
        return Objects.equals(title, musicItem.title) && Objects.equals(artist, musicItem.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist);
    }

    @Override
    public String toString() {
        return "MusicItem{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}

class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void buyMusicItem(MusicStore store, String category, MusicItem item) {
        System.out.println(name + " пытается купить " + item.getTitle() + " - " + item.getArtist());
        boolean success = store.buyMusicItem(category, item);
        if (!success) {
            System.out.println("Покупка не удалась для " + item.getTitle() + " - " + item.getArtist());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
