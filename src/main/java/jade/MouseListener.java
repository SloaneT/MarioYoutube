package jade;

public class MouseListener {
    private static MouseListener instance;
    private double scrollX, scrollY;
    private double xPos, yPos, lastY, lastX;
    private boolean mousebuttonPressed[] = new boolean[3];
    private boolean isDragging;
}
