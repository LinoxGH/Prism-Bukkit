package me.botsko.prism.text;


import me.botsko.prism.Il8n;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.PropertyKey;

import java.util.regex.Pattern;

/**
 * Created for the Prism-Bukkit Project.
 * Created by Narimm on 6/08/2020.
 */
public class ReplaceableTextComponent {

    private Component component;


    private ReplaceableTextComponent(TextComponent component) {
        this.component = component;
    }

    public static ReplaceableTextComponent builder(@PropertyKey(resourceBundle = "languages.message") String key) {
        return new ReplaceableTextComponent(Il8n.getMessage(key));
    }

    public ReplaceableTextComponent replace(String key, String content, Style withStyle) {
        this.component = component.replaceText(Pattern.compile(key),
                builder -> TextComponent.builder().content(content).style(withStyle));
        return this;
    }

    public ReplaceableTextComponent replace(String key, String content) {
        replace(key, content, Style.empty());
        return this;
    }

    public ReplaceableTextComponent replace(String key, Object content, Style withStyle) {
        replace(key, String.valueOf(content), withStyle);
        return this;
    }

    public ReplaceableTextComponent replace(String key, Object content) {
        replace(key, String.valueOf(content), Style.empty());
        return this;
    }

    public ReplaceableTextComponent replaceFirst(String key, Object content) {
        replaceFirst(key, String.valueOf(content));
        return this;
    }

    public ReplaceableTextComponent replaceFirst(String key, String content) {
        this.component = component.replaceFirstText(Pattern.compile(key),
                builder -> TextComponent.builder().content(content));
        return this;
    }

    public Component build() {
        return component;
    }
}