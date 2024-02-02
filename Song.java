// 曲を管理する上で必要な機能をインターフェース化する
// タイトル、アーティスト名、説明文を取得するためのものを定義する
// 曲のカタログを表示するためのものを定義する
public interface Song {
    String getTitle();
    String getArtist();
    String getDescription();
    void displayInfo();
}
