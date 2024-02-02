// Drillの機能を実装するクラス
// 曲のタイトル、アーティスト名、説明文を取得するメソッドをオーバーライドさせる
// 曲の情報を表示するメソッドをオーバーライドさせる
public class DrillSong extends RapSong {

    // 文字列型の変数を定義して受け皿を作る
    private String derivation;

    // コンストラクタを定義して初期化をする
    // 必要な引数はタイトル、アーティスト名、説明文
    public DrillSong(String title, String artist, String description, String derivation) {
        super(title, artist, description);
        this.derivation = derivation;
    }

    // RapSongクラスを継承して
    // Drillの派生を入力するDrillクラス独自の項目を追加する
    public String getDerivation() {
        return derivation;
    }

    // 曲の情報を表示するインターフェースをオーバーライド？（日本語合ってんのか？これ。。。。）
    // とりまDrillの中のタイトル、アーティスト名、説明文を表示する
    // 曲の検索をかけてヒットした時に呼び出す
    @Override
    public void displayInfo() {
        System.out.println("Drillのタイトル： " + getTitle() + ", アーティスト名：" + getArtist() + ", 説明文： " + getDescription() + ", 派生： " + getDerivation());
    }
}
