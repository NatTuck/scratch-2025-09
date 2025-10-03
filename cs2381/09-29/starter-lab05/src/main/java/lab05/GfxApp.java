package lab05;

public interface GfxApp {
       void onTick(GfxWindow gw, long frame);
       void onMouse(GfxWindow gw, int x, int y, int btn);
       void onKey(GfxWindow gw, String key);
}
