/**
 * クイックソート
 */
public class QuickSort extends Common {
    /**
     * 共通処理のコール
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        new QuickSort().doAction(args);
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

        quickSort(data, 0, data.length - 1, order);
    }

    /**
     * ソート処理
     *
     * @param data  ソート対象配列
     * @param left  ソート範囲の開始インデックス
     * @param right ソート範囲の終了インデックス
     * @param order 並び順（true：昇順, false：降順）
     */
    private void quickSort(int[] data, int left, int right, boolean order) {
        if (left >= right) {
            return;
        }

        // 基準値
        int pivot = data[left + (right - left) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            // 基準値より小さい要素を左側から検索
            while (order ? data[i] < pivot : data[i] > pivot) {
                i++;
            }
            // 基準値より大きい要素を右側から検索
            while (order ? data[j] > pivot : data[j] < pivot) {
                j--;
            }

            if (i <= j) {
                // 基準値より小さい要素を左側、大きい要素を右側へ振り分け
                int tmp = data[i];
                data[i++] = data[j];
                data[j--] = tmp;
            }
        }

        // ソート範囲を更新して再帰呼び出し
        if (left < j) {
            quickSort(data, left, j, order);
        }
        if (i < right) {
            quickSort(data, i, right, order);
        }
    }
}
