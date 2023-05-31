/*
                                MIT License

                        Copyright (c) 2023 Mehran1022

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
               furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in all
                    copies or substantial portions of the Software.

        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
                                        SOFTWARE.
*/

package ir.Mehran1022.EventCore;

import ir.Mehran1022.EventCore.Commands.EventCommand;
import ir.Mehran1022.EventCore.Listeners.InventoryClickListener;
import ir.Mehran1022.EventCore.Listeners.PlayerJoinEvent;
import ir.Mehran1022.EventCore.Utils.Common;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Configuration.loadConfig();
        LoadThings();
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        Metrics Metrics = new Metrics(this, 18612);
    }
    private void LoadThings () {
        Common.RegisterEvent(new PlayerJoinEvent(), this);
        Common.RegisterCommand("event", new EventCommand());
        Common.RegisterEvent(new InventoryClickListener(), this);
        Common.RegisterTabCompleter(new TabCompleter(), "event");
    }
    public static Main getInstance () {
        return instance;
    }
}