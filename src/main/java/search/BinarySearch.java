package search;

/**
 * @author huangyb
 * @date 2020/8/6
 */
public class BinarySearch {

    public static int equals(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素
     * @param a
     * @param target
     * @return
     */
    public static int firstEqual(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < target) {
                low = mid + 1;
            } else if (a[mid] > target) {
                high = mid - 1;
            } else {
                if (mid != 0 && a[mid - 1] == target) {
                    high = mid - 1;
                } else {
                    return mid;
                }

            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param a
     * @param target
     * @return
     */
    public static int lastEqual(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < target) {
                low = mid + 1;
            } else if (a[mid] > target) {
                high = mid - 1;
            } else {
                if (mid != a.length - 1 && a[mid + 1] == target) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
        }

        return -1;
    }


    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param target
     * @return
     */
    public static int firstGreaterThanEqual(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < target) {
                low = mid + 1;
            } else if (a[mid] > target) {
                if (mid != 0 && a[mid - 1] >= target) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else {
                if (mid != 0 && a[mid - 1] == target) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param a
     * @param target
     * @return
     */
    public static int lastLessThanEqual(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] > target) {
                high = mid - 1;
            } else if (a[mid] < target) {
                if (mid != a.length - 1 && a[mid + 1] <= target) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                if (mid != a.length - 1 && a[mid + 1] == target) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] i = {1, 2, 3, 3, 3, 3, 5, 6, 7, 8};
        System.out.println(firstEqual(i, 3));
        System.out.println(lastEqual(i, 3));

        System.out.println(firstGreaterThanEqual(i, 4));
        System.out.println(lastLessThanEqual(i, 4));


        System.out.println(equals(new int[]{1, 2, 3, 4, 5, 8, 10, 20, 25}, 8));
    }
}
