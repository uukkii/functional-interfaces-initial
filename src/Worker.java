public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener callback2;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener callback2) {
        this.callback = callback;
        this.callback2 = callback2;
    }


    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 32) {
                callback2.onError("Task " + (i + 1) + " is failed");
            }
            callback.onDone("Task " + (i + 1) + " is done");
        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
}
