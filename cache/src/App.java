import java.util.PriorityQueue;

class ExamRoom {
    PriorityQueue<int[]> pq;
    int n;
    int currStud = 0;

    public ExamRoom(int n) {
        this.pq = new PriorityQueue<>((a, b) -> {
            if ((b[1] - b[0]) / 2 == (a[1] - a[0]) / 2)
                return a[0] - b[0];
            else
                return (b[1] - b[0]) / 2 - (a[1] - a[0]) / 2;
        });
        this.n = n;
        currStud = 0;
    }

    public int seat() {
        currStud++;
        if (pq.size() == 0) {
            pq.offer(new int[] { 0, 2 * n - 2 });
            return 0;
        } else {
            int[] longest = pq.poll();
            int place = longest[0] + (longest[1] - longest[0]) / 2;
            if (place != n - 1) {
                pq.offer(new int[] { place, longest[1] });
            }
            if (place != 0) {
                pq.offer(new int[] { longest[0], place });
            }
            return place;
        }

    }

    public void leave(int p) {
        int[] lp = null, rp = null;
        currStud--;
        if (currStud == 0) {
            pq.clear();
            return;
        }
        for (int[] pair : pq) {
            if (pair[1] == p)
                lp = pair;
            if (pair[0] == p)
                rp = pair;
        }
        if (lp != null)
            pq.remove(lp);
        if (rp != null)
            pq.remove(rp);
        if (lp == null)
            pq.offer(new int[] { -rp[1], rp[1] });
        if (rp == null)
            pq.offer(new int[] { lp[0], 2 * (n - 1) - lp[0] });
        if (lp != null && rp != null)
            pq.offer(new int[] { lp[0], rp[1] });
    }
}
