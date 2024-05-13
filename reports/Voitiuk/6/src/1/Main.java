import java.util.ArrayList;
import java.util.List;

class MusicItem {
    private String type;
    private String genre;
    private String name;
    private double price;

    public static class Builder {
        private String type;
        private String genre;
        private String name;
        private double price;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public MusicItem build() {
            return new MusicItem(this);
        }
    }

    private MusicItem(Builder builder) {
        this.type = builder.type;
        this.genre = builder.genre;
        this.name = builder.name;
        this.price = builder.price;
    }

    @Override
    public String toString() {
        return "MusicItem{" +
                "type='" + type + '\'' +
                ", genre='" + genre + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class MusicStore {
    private static MusicStore instance;
    private List<MusicItem> items = new ArrayList<>();

    private MusicStore() {}

    public static synchronized MusicStore getInstance() {
        if (instance == null) {
            instance = new MusicStore();
        }
        return instance;
    }

    public void addItem(MusicItem item) {
        items.add(item);
    }

    public void serveCustomer(MusicItem item) {
        if (items.contains(item)) {
            System.out.println("Обслуживаем клиента с товаром: " + item);
            items.remove(item);
        } else {
            System.out.println("Извините, данный товар отсутствует на складе: " + item);
        }
    }

    public void displayItems() {
        for (MusicItem item : items) {
            System.out.println(item);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MusicStore store = MusicStore.getInstance();

        MusicItem rockAlbum = new MusicItem.Builder()
                .setType("Альбом")
                .setGenre("Рок")
                .setName("Rock Album 1")
                .setPrice(10.99)
                .build();

        MusicItem jazzAlbum = new MusicItem.Builder()
                .setType("Альбом")
                .setGenre("Джаз")
                .setName("Jazz Album 1")
                .setPrice(12.99)
                .build();

        store.addItem(rockAlbum);
        store.addItem(jazzAlbum);

        System.out.println("Товары в магазине:");
        store.displayItems();

        store.serveCustomer(rockAlbum);
        store.serveCustomer(jazzAlbum);
    }
}
