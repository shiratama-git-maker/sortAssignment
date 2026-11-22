/**
 * マージソート
 */
public class MergeSort extends Common {
    /**
     * 共通処理のコール
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        new MergeSort().doAction(args);
    }

    /**
     * ソート処理の呼び出し
     *
     * @param data  ソート対象配列
     * @param order 並び順（true：昇順、false：降順）
     */
    @Override
    protected void sort(int[] data, boolean order) {
        if (data.length <= 1) {
            return;
        }

        int[] tmp = new int[data.length];
        mergeSort(data, tmp, 0, data.length - 1, order);
    }

    /**
     * ソート処理
     *
     * @param data  ソート対象配列
     * @param tmp   マージ用配列
     * @param left  ソート範囲の開始インデックス
     * @param right ソート範囲の終了インデックス
     * @param order 並び順（true：昇順, false：降順）
     */
    private void mergeSort(int[] data, int[] tmp, int left, int right, boolean order) {
        if (left >= right) {
            return;
        }

        // 中間のインデックスを取得
        int mid = left + (right - left) / 2;

        // 中間のインデックスを基準に、前半と後半に分割してソート
        mergeSort(data, tmp, left, mid, order);
        mergeSort(data, tmp, mid + 1, right, order);

        // ソート済みの前半と後半をマージ
        merge(data, tmp, left, mid, right, order);
    }

    /**
     * マージ処理
     *
     * @param data  整列対象の整数配列
     * @param tmp   マージ用の配列
     * @param left  前半範囲の開始インデックス
     * @param mid   前半範囲の終了インデックス
     * @param right 後半範囲の終了インデックス
     * @param order 並び順（true: 昇順, false: 降順）
     */
    private void merge(int[] data, int[] tmp, int left, int mid, int right, boolean order) {
        for (int i = left; i <= right; i++) {
            tmp[i] = data[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        // 前半と後半の先頭要素を比較し、元の配列に格納
        while (i <= mid && j <= right) {
            if (order ? tmp[i] <= tmp[j] : tmp[i] >= tmp[j]) {
                data[k++] = tmp[i++];
            } else {
                data[k++] = tmp[j++];
            }
        }

        // 前半に残った要素を格納
        while (i <= mid) {
            data[k++] = tmp[i++];
        }

        // 後半に残った要素を格納
        while (j <= right) {
            data[k++] = tmp[j++];
        }
    }
}
