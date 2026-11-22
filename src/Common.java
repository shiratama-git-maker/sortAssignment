import java.util.StringJoiner;

/**
 * 共通処理
 */
public abstract class Common {

    private static final String CONST_TWO = "2";
    private static final String CONST_SORT_START = "並べ替え対象：";
    private static final String CONST_SORT_END = "並べ替え終了：";
    private static final String CONST_IN_SPACE = ".*\\s+.*";
    private static final String CONST_SPACE = "\\s+";
    private static final String CONST_COMMA = "，";
    private static final String CONST_BRACKET_START = "【";
    private static final String CONST_BRACKET_END = "】";

    /**
     * コマンドライン引数を読み取り、変換してソート結果を出力
     *
     * @param args コマンドライン引数
     */
    protected void doAction(String[] args) {
        boolean order = !args[0].equals(CONST_TWO);
        String input = args[1].trim();

        // 入力された数値を整形
        int[] data = parseInput(input);

        System.out.println(CONST_SORT_START + numberFormat(data));

        // ソート処理を行う
        sort(data, order);

        System.out.println(CONST_SORT_END + numberFormat(data));
    }

    /**
     * ソート処理
     *
     * @param data  ソート対象配列
     * @param order 並び順（true：昇順、false：降順）
     */
    protected abstract void sort(int[] data, boolean order);

    /**
     * 入力された数値を整形<br>
     * 空白区切りの場合：そのままで使用<br>
     * 連続した数字のみの場合：2桁に区切って使用
     *
     * @param input 入力文字列
     * @return ソート対象配列
     */
    private int[] parseInput(String input) {
        int[] res;
        // 空白区切りの場合
        if (input.matches(CONST_IN_SPACE)) {
            String[] sp = input.split(CONST_SPACE);
            res = new int[sp.length];
            for (int i = 0; i < sp.length; i++) {
                res[i] = Integer.parseInt(sp[i]);
            }
        }
        // 連続した数字のみの場合
        else {
            int len = input.length();
            res = new int[(len + 1) / 2];
            for (int i = 0; i < len; i += 2) {
                res[i / 2] = Integer.parseInt(input.substring(i, Math.min(i + 2, len)));
            }
        }
        return res;
    }

    /**
     * 入出力内容の整形
     *
     * @param data 対象配列
     * @return 【と】で囲み、カンマで区切った文字列
     */
    private String numberFormat(int[] data) {
        StringJoiner sj = new StringJoiner(CONST_COMMA, CONST_BRACKET_START, CONST_BRACKET_END);
        for (int num : data) {
            sj.add(String.valueOf(num));
        }
        return sj.toString();
    }
}
