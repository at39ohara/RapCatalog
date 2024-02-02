//Trapの機能を実装するクラス
// 曲のタイトル、アーティスト名、説明文を取得するメソッドをオーバーライドさせる
// 曲の情報を表示するメソッドをオーバーライドさせる
public class TrapSong implements Song {

    // 文字列型の変数を定義して受け皿を作る
    private String title;
    private String artist;
    private String description;

    // コンストラクタを定義して初期化をする
    // 必要な引数はタイトル、アーティスト名、説明文
    public TrapSong(String title, String artist, String description) {
        this.title = title;
        this.artist = artist;
        this.description = description;
    }

    // タイトルを取得し返すメソッドをオーバーライドさせる
    // このクラスの中だとTrapのタイトルを返すことになる
    @Override
    public String getTitle() {
        return title;
    }

    // アーティスト名を取得し返すメソッドをオーバーライドさせる
    // このクラスの中だとTrapのアーティスト名を返すことになる
    @Override
    public String getArtist() {
        return artist;
    }

    // 説明文を取得し返すメソッドをオーバーライドさせる
    // このクラスの中だとTrapの説明文を返すことになる
    @Override
    public String getDescription() {
        return description;
    }

    // 曲の情報を表示するインターフェースをオーバーライド
    // タイトル、アーティスト名、説明文を表示する
    @Override
    public void displayInfo() {
        System.out.println("Trapのタイトル： " + title + ", アーティスト名： " + artist + ", 説明文： " + description);
    }
}
