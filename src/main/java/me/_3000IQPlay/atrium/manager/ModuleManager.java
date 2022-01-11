package me._3000IQPlay.atrium.manager;

import me._3000IQPlay.atrium.event.events.Render2DEvent;
import me._3000IQPlay.atrium.event.events.Render3DEvent;
import me._3000IQPlay.atrium.features.Feature;
import me._3000IQPlay.atrium.features.gui.AtriumGui;
import me._3000IQPlay.atrium.features.modules.Module;
import me._3000IQPlay.atrium.features.modules.client.*;
import me._3000IQPlay.atrium.features.modules.combat.*;
import me._3000IQPlay.atrium.features.modules.exploit.*;
import me._3000IQPlay.atrium.features.modules.misc.*;
import me._3000IQPlay.atrium.features.modules.movement.*;
import me._3000IQPlay.atrium.features.modules.player.*;
import me._3000IQPlay.atrium.features.modules.render.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class ModuleManager
        extends Feature {
    public ArrayList<Module> modules = new ArrayList();
    public List<Module> sortedModules = new ArrayList<Module>();
    public List<Module> alphabeticallySortedModules = new ArrayList<Module>();
    public Map<Module, Color> moduleColorMap = new HashMap<Module, Color>();

    public void init() {
        this.modules.add(new ModuleTools());
        this.modules.add(new FriendSettings());
        this.modules.add(new OffhandRewriten());
        this.modules.add(new Surround());
        this.modules.add(new AutoTrap());
        this.modules.add(new AutoCrystal());
        this.modules.add(new Criticals());
        this.modules.add(new Killaura());
        this.modules.add(new HoleFiller());
        this.modules.add(new AutoWeb());
        this.modules.add(new ChatModifier());
        this.modules.add(new BuildHeight());
        this.modules.add(new AutoRespawn());
        this.modules.add(new NoRotate());
        this.modules.add(new MCF());
        this.modules.add(new AutoLog());
        this.modules.add(new AutoReconnect());
        this.modules.add(new Logger());
        this.modules.add(new RPC());
        this.modules.add(new AutoGG());
        this.modules.add(new ReverseStep());
        this.modules.add(new Strafe());
        this.modules.add(new Velocity());
        this.modules.add(new Speed());
        this.modules.add(new Step());
        this.modules.add(new AntiVoid());
        this.modules.add(new ElytraFlight());
        this.modules.add(new NoSlowDown());
        this.modules.add(new FakePlayer());
        this.modules.add(new TimerSpeed());
        this.modules.add(new FastPlace());
        this.modules.add(new Freecam());
        this.modules.add(new Speedmine());
        this.modules.add(new MultiTask());
        this.modules.add(new XCarry());
        this.modules.add(new Replenish());
        this.modules.add(new MCP());
        this.modules.add(new Yaw());
        this.modules.add(new NoRender());
        this.modules.add(new Fullbright());
        this.modules.add(new CameraClip());
        this.modules.add(new Chams());
        this.modules.add(new ESP());
        this.modules.add(new HoleESP());
        this.modules.add(new BlockHighlight());
        this.modules.add(new Trajectories());
        this.modules.add(new LogoutSpots());
        this.modules.add(new XRay());
        this.modules.add(new VoidESP());
        this.modules.add(new CrystalModify());
        this.modules.add(new Notifications());
        this.modules.add(new HUD());
        this.modules.add(new ToolTips());
        this.modules.add(new FontMod());
        this.modules.add(new ClickGui());
        this.modules.add(new Managers());
        this.modules.add(new Components());
        this.modules.add(new Capes());
        this.modules.add(new Colors());
        this.modules.add(new ServerModule());
        this.modules.add(new Media());
        this.modules.add(new IRC());
		this.modules.add(new PopChams());
		this.modules.add(new Burrow());
		this.modules.add(new BowSpam());
		this.modules.add(new Flatten());
		this.modules.add(new Quiver());
		this.modules.add(new Nametags());
		this.modules.add(new SilentXP());
		this.modules.add(new AutoArmor());
		this.modules.add(new Sprint());
		this.modules.add(new CSGOWatermark());
		this.modules.add(new ViewModel());
		this.modules.add(new Anchor());
		this.modules.add(new NoEntityTrace());
		this.modules.add(new Blink());
		this.modules.add(new NoSoundLag());
		this.modules.add(new FastProjectiles());
		this.modules.add(new BoatFly());
		this.modules.add(new PacketFly());
		this.modules.add(new Scaffold());
		this.modules.add(new BowAim());
		this.modules.add(new Flight());
		this.modules.add(new Offhand());
		this.modules.add(new NoHandShake());
		this.modules.add(new SkyColor());
		this.modules.add(new Suicide());
		this.modules.add(new BedAura());
		this.modules.add(new GreenText());
		this.modules.add(new AutoSignKick());
		this.modules.add(new OldFagDupe());
		this.modules.add(new MountBypass());
		this.modules.add(new PenisESP());
		this.modules.add(new AutoBuilder());
		this.modules.add(new CevBreaker());
		this.modules.add(new NoGlitchBlocks());
		this.modules.add(new PistonAura());
		this.modules.add(new PacketEat());
		this.modules.add(new AntiDDoS());
		this.modules.add(new AutoCity());
	    	this.modules.add(new AntiLog4j());
		this.modules.add(new AutoKickBow());
		this.moduleColorMap.put(this.getModuleByClass(AutoKickBow.class), new Color(164, 63, 254));
		this.moduleColorMap.put(this.getModuleByClass(AntiLog4j.class), new Color(74, 83, 46));
		this.moduleColorMap.put(this.getModuleByClass(AutoCity.class), new Color(97, 173, 162));
		this.moduleColorMap.put(this.getModuleByClass(AntiDDoS.class), new Color(172, 133, 192));
		this.moduleColorMap.put(this.getModuleByClass(PacketEat.class), new Color(215, 81, 248));
		this.moduleColorMap.put(this.getModuleByClass(PistonAura.class), new Color(85, 94, 58));
		this.moduleColorMap.put(this.getModuleByClass(NoGlitchBlocks.class), new Color(53, 86, 134));
		this.moduleColorMap.put(this.getModuleByClass(CevBreaker.class), new Color(255, 68, 183));
		this.moduleColorMap.put(this.getModuleByClass(AutoBuilder.class), new Color(75, 247, 27));
		this.moduleColorMap.put(this.getModuleByClass(PenisESP.class), new Color(52, 148, 38));
		this.moduleColorMap.put(this.getModuleByClass(MountBypass.class), new Color(246, 124, 137));
		this.moduleColorMap.put(this.getModuleByClass(OldFagDupe.class), new Color(174, 64, 83));
		this.moduleColorMap.put(this.getModuleByClass(AutoSignKick.class), new Color(135, 198, 36));
		this.moduleColorMap.put(this.getModuleByClass(GreenText.class), new Color(182, 218, 153));
		this.moduleColorMap.put(this.getModuleByClass(BedAura.class), new Color(35, 28, 192));
		this.moduleColorMap.put(this.getModuleByClass(Suicide.class), new Color(36, 147, 128));
		this.moduleColorMap.put(this.getModuleByClass(SkyColor.class), new Color(123, 32, 13));
		this.moduleColorMap.put(this.getModuleByClass(NoHandShake.class), new Color(12, 12, 135));
		this.moduleColorMap.put(this.getModuleByClass(Offhand.class), new Color(129, 177, 95));
		this.moduleColorMap.put(this.getModuleByClass(Flight.class), new Color(73, 21, 92));
		this.moduleColorMap.put(this.getModuleByClass(BowAim.class), new Color(62, 98, 71));
		this.moduleColorMap.put(this.getModuleByClass(Scaffold.class), new Color(123, 9, 200));
		this.moduleColorMap.put(this.getModuleByClass(PacketFly.class), new Color(211, 82, 112));
		this.moduleColorMap.put(this.getModuleByClass(BoatFly.class), new Color(67, 111, 38));
		this.moduleColorMap.put(this.getModuleByClass(FastProjectiles.class), new Color(199, 91, 251));
		this.moduleColorMap.put(this.getModuleByClass(NoSoundLag.class), new Color(57, 133, 192));
		this.moduleColorMap.put(this.getModuleByClass(Blink.class), new Color(61, 255, 0));
		this.moduleColorMap.put(this.getModuleByClass(NoEntityTrace.class), new Color(215, 17, 72));
		this.moduleColorMap.put(this.getModuleByClass(Anchor.class), new Color(0, 51, 192));
		this.moduleColorMap.put(this.getModuleByClass(ViewModel.class), new Color(81, 62, 1));
		this.moduleColorMap.put(this.getModuleByClass(CSGOWatermark.class), new Color(34, 153, 51));
		this.moduleColorMap.put(this.getModuleByClass(Sprint.class), new Color(135, 52, 216));
		this.moduleColorMap.put(this.getModuleByClass(SilentXP.class), new Color(52, 236, 25));
		this.moduleColorMap.put(this.getModuleByClass(AutoArmor.class), new Color(65, 62, 252));
		this.moduleColorMap.put(this.getModuleByClass(PopChams.class), new Color(84, 152, 76));
		this.moduleColorMap.put(this.getModuleByClass(BowSpam.class), new Color(57, 23, 83));
		this.moduleColorMap.put(this.getModuleByClass(Burrow.class), new Color(32, 125, 19));
		this.moduleColorMap.put(this.getModuleByClass(Flatten.class), new Color(163, 34, 39));
	    this.moduleColorMap.put(this.getModuleByClass(Quiver.class), new Color(128, 204, 79));
        this.moduleColorMap.put(this.getModuleByClass(AutoCrystal.class), new Color(255, 15, 43));
        this.moduleColorMap.put(this.getModuleByClass(AutoTrap.class), new Color(193, 49, 244));
        this.moduleColorMap.put(this.getModuleByClass(Criticals.class), new Color(204, 151, 184));
        this.moduleColorMap.put(this.getModuleByClass(HoleFiller.class), new Color(166, 55, 110));
        this.moduleColorMap.put(this.getModuleByClass(Killaura.class), new Color(255, 37, 0));
        this.moduleColorMap.put(this.getModuleByClass(OffhandRewriten.class), new Color(185, 212, 144));
        this.moduleColorMap.put(this.getModuleByClass(Surround.class), new Color(100, 0, 150));
        this.moduleColorMap.put(this.getModuleByClass(AutoWeb.class), new Color(11, 161, 121));
        this.moduleColorMap.put(this.getModuleByClass(AutoGG.class), new Color(240, 49, 110));
        this.moduleColorMap.put(this.getModuleByClass(AutoLog.class), new Color(176, 176, 176));
        this.moduleColorMap.put(this.getModuleByClass(AutoReconnect.class), new Color(17, 85, 153));
        this.moduleColorMap.put(this.getModuleByClass(BuildHeight.class), new Color(64, 136, 199));
        this.moduleColorMap.put(this.getModuleByClass(ChatModifier.class), new Color(255, 59, 216));
        this.moduleColorMap.put(this.getModuleByClass(Logger.class), new Color(186, 0, 109));
        this.moduleColorMap.put(this.getModuleByClass(MCF.class), new Color(17, 85, 255));
		this.moduleColorMap.put(this.getModuleByClass(NoRotate.class), new Color(69, 81, 223));
        this.moduleColorMap.put(this.getModuleByClass(RPC.class), new Color(0, 64, 255));
        this.moduleColorMap.put(this.getModuleByClass(ToolTips.class), new Color(209, 125, 156));
        this.moduleColorMap.put(this.getModuleByClass(BlockHighlight.class), new Color(103, 182, 224));
        this.moduleColorMap.put(this.getModuleByClass(CameraClip.class), new Color(247, 169, 107));
        this.moduleColorMap.put(this.getModuleByClass(Chams.class), new Color(34, 152, 34));
        this.moduleColorMap.put(this.getModuleByClass(ESP.class), new Color(255, 27, 155));
        this.moduleColorMap.put(this.getModuleByClass(Fullbright.class), new Color(255, 164, 107));
        this.moduleColorMap.put(this.getModuleByClass(HoleESP.class), new Color(95, 83, 130));
        this.moduleColorMap.put(this.getModuleByClass(LogoutSpots.class), new Color(2, 135, 134));
        this.moduleColorMap.put(this.getModuleByClass(Nametags.class), new Color(98, 82, 223));
        this.moduleColorMap.put(this.getModuleByClass(NoRender.class), new Color(255, 164, 107));
        this.moduleColorMap.put(this.getModuleByClass(Trajectories.class), new Color(98, 18, 223));
        this.moduleColorMap.put(this.getModuleByClass(VoidESP.class), new Color(68, 178, 142));
        this.moduleColorMap.put(this.getModuleByClass(XRay.class), new Color(217, 118, 37));
        this.moduleColorMap.put(this.getModuleByClass(ElytraFlight.class), new Color(55, 161, 201));
        this.moduleColorMap.put(this.getModuleByClass(NoSlowDown.class), new Color(61, 204, 78));
        this.moduleColorMap.put(this.getModuleByClass(Speed.class), new Color(55, 161, 196));
        this.moduleColorMap.put(this.getModuleByClass(AntiVoid.class), new Color(86, 53, 98));
        this.moduleColorMap.put(this.getModuleByClass(Step.class), new Color(144, 212, 203));
        this.moduleColorMap.put(this.getModuleByClass(Strafe.class), new Color(0, 204, 255));
        this.moduleColorMap.put(this.getModuleByClass(Velocity.class), new Color(115, 134, 140));
        this.moduleColorMap.put(this.getModuleByClass(ReverseStep.class), new Color(1, 134, 140));
        this.moduleColorMap.put(this.getModuleByClass(FakePlayer.class), new Color(37, 192, 170));
        this.moduleColorMap.put(this.getModuleByClass(FastPlace.class), new Color(217, 118, 37));
        this.moduleColorMap.put(this.getModuleByClass(Freecam.class), new Color(206, 232, 128));
        this.moduleColorMap.put(this.getModuleByClass(MCP.class), new Color(153, 68, 170));
        this.moduleColorMap.put(this.getModuleByClass(MultiTask.class), new Color(17, 223, 235));
        this.moduleColorMap.put(this.getModuleByClass(Replenish.class), new Color(153, 223, 235));
        this.moduleColorMap.put(this.getModuleByClass(Speedmine.class), new Color(152, 166, 113));
        this.moduleColorMap.put(this.getModuleByClass(TimerSpeed.class), new Color(255, 133, 18));
        this.moduleColorMap.put(this.getModuleByClass(XCarry.class), new Color(254, 161, 51));
        this.moduleColorMap.put(this.getModuleByClass(Yaw.class), new Color(115, 39, 141));
        this.moduleColorMap.put(this.getModuleByClass(Capes.class), new Color(26, 135, 104));
        this.moduleColorMap.put(this.getModuleByClass(ClickGui.class), new Color(26, 81, 135));
        this.moduleColorMap.put(this.getModuleByClass(Colors.class), new Color(135, 133, 26));
        this.moduleColorMap.put(this.getModuleByClass(Components.class), new Color(135, 26, 26));
        this.moduleColorMap.put(this.getModuleByClass(FontMod.class), new Color(135, 26, 88));
        this.moduleColorMap.put(this.getModuleByClass(HUD.class), new Color(110, 26, 135));
        this.moduleColorMap.put(this.getModuleByClass(Managers.class), new Color(26, 90, 135));
        this.moduleColorMap.put(this.getModuleByClass(Notifications.class), new Color(170, 153, 255));
        this.moduleColorMap.put(this.getModuleByClass(ServerModule.class), new Color(60, 110, 175));
        this.moduleColorMap.put(this.getModuleByClass(Media.class), new Color(138, 45, 13));
        for (Module module : this.modules) {
            module.animation.start();
        }
    }

    public Module getModuleByName(String name) {
        for (Module module : this.modules) {
            if (!module.getName().equalsIgnoreCase(name)) continue;
            return module;
        }
        return null;
    }

    public <T extends Module> T getModuleByClass(Class<T> clazz) {
        for (Module module : this.modules) {
            if (!clazz.isInstance(module)) continue;
            return (T) module;
        }
        return null;
    }

    public void enableModule(Class clazz) {
        Object module = this.getModuleByClass(clazz);
        if (module != null) {
            ((Module) module).enable();
        }
    }

    public void disableModule(Class clazz) {
        Object module = this.getModuleByClass(clazz);
        if (module != null) {
            ((Module) module).disable();
        }
    }

    public void enableModule(String name) {
        Module module = this.getModuleByName(name);
        if (module != null) {
            module.enable();
        }
    }

    public void disableModule(String name) {
        Module module = this.getModuleByName(name);
        if (module != null) {
            module.disable();
        }
    }

    public boolean isModuleEnabled(String name) {
        Module module = this.getModuleByName(name);
        return module != null && module.isOn();
    }

    public boolean isModuleEnabled(Class clazz) {
        Object module = this.getModuleByClass(clazz);
        return module != null && ((Module) module).isOn();
    }

    public Module getModuleByDisplayName(String displayName) {
        for (Module module : this.modules) {
            if (!module.getDisplayName().equalsIgnoreCase(displayName)) continue;
            return module;
        }
        return null;
    }

    public ArrayList<Module> getEnabledModules() {
        ArrayList<Module> enabledModules = new ArrayList<Module>();
        for (Module module : this.modules) {
            if (!module.isEnabled() && !module.isSliding()) continue;
            enabledModules.add(module);
        }
        return enabledModules;
    }

    public ArrayList<Module> getModulesByCategory(Module.Category category) {
        ArrayList<Module> modulesCategory = new ArrayList<Module>();
        this.modules.forEach(module -> {
            if (module.getCategory() == category) {
                modulesCategory.add(module);
            }
        });
        return modulesCategory;
    }

    public List<Module.Category> getCategories() {
        return Arrays.asList(Module.Category.values());
    }

    public void onLoad() {
        this.modules.stream().filter(Module::listening).forEach(((EventBus) MinecraftForge.EVENT_BUS)::register);
        this.modules.forEach(Module::onLoad);
    }

    public void onUpdate() {
        this.modules.stream().filter(Feature::isEnabled).forEach(Module::onUpdate);
    }

    public void onTick() {
        this.modules.stream().filter(Feature::isEnabled).forEach(Module::onTick);
    }

    public void onRender2D(Render2DEvent event) {
        this.modules.stream().filter(Feature::isEnabled).forEach(module -> module.onRender2D(event));
    }

    public void onRender3D(Render3DEvent event) {
        this.modules.stream().filter(Feature::isEnabled).forEach(module -> module.onRender3D(event));
    }

    public void sortModules(boolean reverse) {
        this.sortedModules = this.getEnabledModules().stream().filter(Module::isDrawn).sorted(Comparator.comparing(module -> this.renderer.getStringWidth(module.getFullArrayString()) * (reverse ? -1 : 1))).collect(Collectors.toList());
    }

    public void alphabeticallySortModules() {
        this.alphabeticallySortedModules = this.getEnabledModules().stream().filter(Module::isDrawn).sorted(Comparator.comparing(Module::getDisplayName)).collect(Collectors.toList());
    }

    public void onLogout() {
        this.modules.forEach(Module::onLogout);
    }

    public void onLogin() {
        this.modules.forEach(Module::onLogin);
    }

    public void onUnload() {
        this.modules.forEach(MinecraftForge.EVENT_BUS::unregister);
        this.modules.forEach(Module::onUnload);
    }

    public void onUnloadPost() {
        for (Module module : this.modules) {
            module.enabled.setValue(false);
        }
    }

    public void onKeyPressed(int eventKey) {
        if (eventKey == 0 || !Keyboard.getEventKeyState() || ModuleManager.mc.currentScreen instanceof AtriumGui) {
            return;
        }
        this.modules.forEach(module -> {
            if (module.getBind().getKey() == eventKey) {
                module.toggle();
            }
        });
    }

    public List<Module> getAnimationModules(Module.Category category) {
        ArrayList<Module> animationModules = new ArrayList<Module>();
        for (Module module : this.getEnabledModules()) {
            if (module.getCategory() != category || module.isDisabled() || !module.isSliding() || !module.isDrawn())
                continue;
            animationModules.add(module);
        }
        return animationModules;
    }
}

