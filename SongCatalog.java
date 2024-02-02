import java.util.List;
import java.util.ArrayList;


// 曲のカタログを管理するクラス
class SongCatalog {
    // 曲のリストを定義する
    private List<Song> songList;

    // コンストラクタを定義
    // Stringだとpuclic SongCatalogの（）の中にString 〇〇と書くのに
    // なんでリストになると入力しないのかわからない　なんか書かなかったら上手くいってしまった
    public SongCatalog() {
        this.songList = new ArrayList<>();
    }

    // 曲を追加するメソッド
    // 曲を追加する時にRapSongとかTrapSongをnewしてコンストラクタの値をぶっこむ
    public void addSong(Song song) {
        songList.add(song);
    }

    // 曲を表示する
    public void displaySongs() {
        System.out.println();
        System.out.println("曲の一覧：");

        // for文でsongListの中のSongインターフェースを実装したオブジェクトにdisplayInfoを呼び出している
        // 結果、songListの中のものが表示される
        for (Song song : songList) {
            song.displayInfo();
        }
    }

    // 曲を検索する
    public Song searchSong(String title) {
        // for文でsongListの中の全ての曲名と入力された曲名を比較して
        // 大文字小文字を無視して一致するかどうかを判定して一致していれば曲名を返す
        for (Song song : songList) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        // 曲が見つからない場合はnullを返す
        return null;
    }

    // 曲を削除する
    public void removeSong(String title) {
        // searchSongで曲名を検索しsongRemoveに格納
        // それがnullでない場合はリストから曲を削除する
        Song songToRemove = searchSong(title);
        if (songToRemove != null) {
            songList.remove(songToRemove);
            System.out.println("この曲を削除しました： " + title);
        } else {
            System.out.println("この曲は見つからなかったため削除できませんでした： " + title);
        }
    }
}