//Trapの機能を実装するクラス
// 曲のタイトル、アーティスト名、説明文を取得するメソッドをオーバーライドさせる
// 曲の情報を表示するメソッドをオーバーライドさせる
public class TrapSong extends RapSong {

    // 文字列型の変数を定義して受け皿を作る
    private int bpm;

    // コンストラクタを定義して初期化をする
    // 必要な引数はタイトル、アーティスト名、説明文
    public TrapSong(String title, String artist, String description, int bpm) {
        super(title, artist, description);
        this.bpm = bpm;
    }

    // RapSongクラスを継承して
    // その曲のBMPを入力するTrapクラス独自の項目を追加する
    public int getBPM() {
        return bpm;
    }

    // 曲の情報を表示するインターフェースをオーバーライド
    // タイトル、アーティスト名、説明文を表示する
    @Override
    public void displayInfo() {
        System.out.println("Trapのタイトル： " + getTitle() + ", アーティスト名： " + getArtist() + ", 説明文： " + getDescription() + ", BPM：" + getBPM());
    }
}
