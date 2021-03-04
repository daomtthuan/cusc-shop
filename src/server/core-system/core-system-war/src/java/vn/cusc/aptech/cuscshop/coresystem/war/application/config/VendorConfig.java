package vn.cusc.aptech.cuscshop.coresystem.war.application.config;

import vn.cusc.aptech.cuscshop.coresystem.war.application.config.moudles.StyleModule;
import vn.cusc.aptech.cuscshop.coresystem.war.application.config.moudles.ScriptModule;

public class VendorConfig {

    private final StyleModule[] styles;
    private final ScriptModule[] scripts;

    public VendorConfig(final StyleModule[] styles, final ScriptModule[] scripts) {
        this.styles = styles;
        this.scripts = scripts;
    }

    public StyleModule[] getStyles() {
        return styles;
    }

    public ScriptModule[] getScripts() {
        return scripts;
    }

}
