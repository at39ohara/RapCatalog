import java.util.InputMismatchException;
import java.util.Scanner;

// メイン実行クラス
// ループを使用して番号選択式で曲の追加や削除、閲覧ができるようにする
public class Start {
    public static void main(String[] args) {
        // 曲のカタログのインスタンスを生成
        SongCatalog catalog = new SongCatalog();
        // スキャナーインスタンスを生成
        Scanner scanner = new Scanner(System.in);

        // ループ内で入力された番号を格納しておくためのint型変数を定義
        int choice;

        do {
            try {
                // 改行を加えて見やすく
                // それぞれの番号の機能の説明文を表示する
                System.out.println();
                System.out.println("機能を選択できます：");
                System.out.println();
                System.out.println("1. その他のラップを追加する：");
                System.out.println("2. Trapを追加する：");
                System.out.println("3. Drillを追加する：");
                System.out.println("4. 曲を表示する：");
                System.out.println("5. 曲を検索する：");
                System.out.println("6. 曲を削除する：");
                System.out.println("0. プログラムを終了する：");
                System.out.println();
                System.out.print("機能を選択し番号を入力してください： ");

                // choiceに入力された整数を格納する
                choice = scanner.nextInt();
                // 改行文をクリアしないとエラーが出る。なんでエラーが出るのか仕組みはわからない
                scanner.nextLine();

                // switch文でケースを選択できるようにする（）のなかのchoiceの値によってどのケースになるかが変わる
                switch (choice) {

                    // その他のラップを追加する
                    case 1:
                        System.out.println();
                        System.out.print("その他のラップの曲名を入力してください： ");
                        String rapTitle = scanner.nextLine();
                        System.out.print("この曲のアーティスト名を入力してください： ");
                        String rapArtist = scanner.nextLine();
                        System.out.print("この曲の説明文を入力してください： ");
                        String rapDescription = scanner.nextLine();
                        // addSongにnewしてコンストラクタの値をぶっこむ
                        catalog.addSong(new RapSong(rapTitle, rapArtist, rapDescription));
                        System.out.println();
                        System.out.println("正常に曲が追加されました。");
                        break;

                    // Trapを追加する
                    case 2:
                        System.out.println();
                        System.out.print("Trapの曲名を入力してください： ");
                        String trapTitle = scanner.nextLine();
                        System.out.print("このTrapのアーティスト名を入力してください： ");
                        String trapArtist = scanner.nextLine();
                        System.out.print("このTrapの説明文を入力してください： ");
                        String trapDescription = scanner.nextLine();
                        System.out.print("このTrapのBPMを入力してください：");
                        int trapBPM = scanner.nextInt();
                        // addSongにnewしてコンストラクタの値をぶっこむ
                        catalog.addSong(new TrapSong(trapTitle, trapArtist, trapDescription, trapBPM));
                        System.out.println();
                        System.out.println("正常に曲が追加されました。");
                        break;

                    // Drillを追加する
                    case 3:
                        System.out.println();
                        System.out.print("Drillの曲名を入力してください：");
                        String drillTitle = scanner.nextLine();
                        System.out.print("このDrillのアーティスト名を入力してください： ");
                        String drillArtist = scanner.nextLine();
                        System.out.print("このDrillの説明文を入力してください：");
                        String drillDescription = scanner.nextLine();
                        System.out.print("このDrillの派生を入力してください：");
                        String drillDerivation = scanner.nextLine();
                        // addSongにnewしてコンストラクタの値をぶっこむ
                        catalog.addSong(new DrillSong(drillTitle, drillArtist, drillDescription, drillDerivation));
                        System.out.println();
                        System.out.println("正常に曲が追加されました。");
                        break;
                    // 曲のカタログを表示するメソッドを呼び出す
                    case 4:
                        catalog.displaySongs();
                        break;

                    // 曲を検索する
                    case 5:
                        System.out.println();
                        System.out.print("検索したい曲名を入力してください： ");
                        // 入力された曲名をserchTitleに格納する
                        String searchTitle = scanner.nextLine();
                        //入力した曲名を引数に曲を検索するメソッドを実行し、結果をfoundSongに格納
                        Song foundSong = catalog.searchSong(searchTitle);
                        // 帰ってきた結果がnullでない場合はfoundSongの曲情報を表示する機能を実行
                        if (foundSong != null) {
                            System.out.println("曲が見つかりました。");
                            foundSong.displayInfo();
                            // そうでないなら見つからなかったと表示
                        } else {
                            System.out.println("曲がみつかりませんでした。");
                        }
                        break;

                    // 曲を削除する
                    case 6:
                        System.out.println();
                        System.out.print("削除したい曲名を入力してください： ");
                        // 削除したい曲名を入力させて格納する
                        String removeTitle = scanner.nextLine();
                        // 曲を削除するメソッドを実行する
                        catalog.removeSong(removeTitle);
                        break;
                    
                    // プログラムを終了する
                    case 0:
                        System.out.println();
                        System.out.println("プログラムを終了します。ご利用ありがとうございました。");
                        break;

                    // defaultで無効な選択肢を弾く
                    default:
                        System.out.println();
                        System.out.println("無効な選択肢です。1 ~ 5の中で選択し入力してください。");
                }
            // 入力された文字が整数でなかった場合に弾く
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("無効な入力です。整数を入力してください。");
                // 入力をクリアしてループを継続する
                scanner.nextLine();
                 // ループを継続させるためにchoiceをマイナス1して再設定する
                choice = -1;
            }
            // 入力された整数が０の場合ループを抜けてプログラムを終了する
            // 逆に言えば、0でない場合はずっとループし続けることを意味する
        } while (choice != 0);

        // スキャナーをクローズさせる
        // スキャナーの記事を見るとどれもクローズしろとなっていたが理由はいまいちわからん
        scanner.close();
    }
}
