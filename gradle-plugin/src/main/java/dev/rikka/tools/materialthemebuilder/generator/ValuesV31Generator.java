package dev.rikka.tools.materialthemebuilder.generator;

import com.google.common.base.CaseFormat;
import dev.rikka.tools.materialthemebuilder.MaterialTheme;
import dev.rikka.tools.materialthemebuilder.MaterialThemeBuilderExtension;
import dev.rikka.tools.materialthemebuilder.Util;
import hct.Hct;

import java.io.File;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

public class ValuesV31Generator extends ValuesGenerator {

    private final MaterialThemeBuilderExtension extension;

    public ValuesV31Generator(File file, MaterialThemeBuilderExtension extension) {
        super(file);
        this.extension = extension;
    }

    @Override
    protected void onGenerate() {
        extension.getThemes().forEach(this::writeTheme);
    }

    private void writeStylesForTheme(
            String nameLowerUnderScore,
            String nameUpperCamel,
            String lightThemeNameFormat, String parentLightThemeName,
            String darkThemeNameFormat, String parentDarkThemeName) {

        String s = "<item name=\"palettePrimary100\">@android:color/system_accent1_0</item>\n" +
                "<item name=\"palettePrimary99\">@android:color/system_accent1_10</item>\n" +
                "<item name=\"palettePrimary95\">@android:color/system_accent1_50</item>\n" +
                "<item name=\"palettePrimary90\">@android:color/system_accent1_100</item>\n" +
                "<item name=\"palettePrimary80\">@android:color/system_accent1_200</item>\n" +
                "<item name=\"palettePrimary70\">@android:color/system_accent1_300</item>\n" +
                "<item name=\"palettePrimary60\">@android:color/system_accent1_400</item>\n" +
                "<item name=\"palettePrimary50\">@android:color/system_accent1_500</item>\n" +
                "<item name=\"palettePrimary40\">@android:color/system_accent1_600</item>\n" +
                "<item name=\"palettePrimary30\">@android:color/system_accent1_700</item>\n" +
                "<item name=\"palettePrimary20\">@android:color/system_accent1_800</item>\n" +
                "<item name=\"palettePrimary10\">@android:color/system_accent1_900</item>\n" +
                "<item name=\"palettePrimary0\">@android:color/system_accent1_1000</item>\n" +
                "<item name=\"paletteSecondary100\">@android:color/system_accent2_0</item>\n" +
                "<item name=\"paletteSecondary99\">@android:color/system_accent2_10</item>\n" +
                "<item name=\"paletteSecondary95\">@android:color/system_accent2_50</item>\n" +
                "<item name=\"paletteSecondary90\">@android:color/system_accent2_100</item>\n" +
                "<item name=\"paletteSecondary80\">@android:color/system_accent2_200</item>\n" +
                "<item name=\"paletteSecondary70\">@android:color/system_accent2_300</item>\n" +
                "<item name=\"paletteSecondary60\">@android:color/system_accent2_400</item>\n" +
                "<item name=\"paletteSecondary50\">@android:color/system_accent2_500</item>\n" +
                "<item name=\"paletteSecondary40\">@android:color/system_accent2_600</item>\n" +
                "<item name=\"paletteSecondary30\">@android:color/system_accent2_700</item>\n" +
                "<item name=\"paletteSecondary20\">@android:color/system_accent2_800</item>\n" +
                "<item name=\"paletteSecondary10\">@android:color/system_accent2_900</item>\n" +
                "<item name=\"paletteSecondary0\">@android:color/system_accent2_1000</item>\n" +
                "<item name=\"paletteTertiary100\">@android:color/system_accent3_0</item>\n" +
                "<item name=\"paletteTertiary99\">@android:color/system_accent3_10</item>\n" +
                "<item name=\"paletteTertiary95\">@android:color/system_accent3_50</item>\n" +
                "<item name=\"paletteTertiary90\">@android:color/system_accent3_100</item>\n" +
                "<item name=\"paletteTertiary80\">@android:color/system_accent3_200</item>\n" +
                "<item name=\"paletteTertiary70\">@android:color/system_accent3_300</item>\n" +
                "<item name=\"paletteTertiary60\">@android:color/system_accent3_400</item>\n" +
                "<item name=\"paletteTertiary50\">@android:color/system_accent3_500</item>\n" +
                "<item name=\"paletteTertiary40\">@android:color/system_accent3_600</item>\n" +
                "<item name=\"paletteTertiary30\">@android:color/system_accent3_700</item>\n" +
                "<item name=\"paletteTertiary20\">@android:color/system_accent3_800</item>\n" +
                "<item name=\"paletteTertiary10\">@android:color/system_accent3_900</item>\n" +
                "<item name=\"paletteTertiary0\">@android:color/system_accent3_1000</item>\n" +
                "<item name=\"paletteNeutral100\">@android:color/system_neutral1_0</item>\n" +
                "<item name=\"paletteNeutral99\">@android:color/system_neutral1_10</item>\n" +
                "<item name=\"paletteNeutral95\">@android:color/system_neutral1_50</item>\n" +
                "<item name=\"paletteNeutral90\">@android:color/system_neutral1_100</item>\n" +
                "<item name=\"paletteNeutral80\">@android:color/system_neutral1_200</item>\n" +
                "<item name=\"paletteNeutral70\">@android:color/system_neutral1_300</item>\n" +
                "<item name=\"paletteNeutral60\">@android:color/system_neutral1_400</item>\n" +
                "<item name=\"paletteNeutral50\">@android:color/system_neutral1_500</item>\n" +
                "<item name=\"paletteNeutral40\">@android:color/system_neutral1_600</item>\n" +
                "<item name=\"paletteNeutral30\">@android:color/system_neutral1_700</item>\n" +
                "<item name=\"paletteNeutral20\">@android:color/system_neutral1_800</item>\n" +
                "<item name=\"paletteNeutral10\">@android:color/system_neutral1_900</item>\n" +
                "<item name=\"paletteNeutral0\">@android:color/system_neutral1_1000</item>\n" +
                "<item name=\"paletteNeutralVariant100\">@android:color/system_neutral2_0</item>\n" +
                "<item name=\"paletteNeutralVariant99\">@android:color/system_neutral2_10</item>\n" +
                "<item name=\"paletteNeutralVariant95\">@android:color/system_neutral2_50</item>\n" +
                "<item name=\"paletteNeutralVariant90\">@android:color/system_neutral2_100</item>\n" +
                "<item name=\"paletteNeutralVariant80\">@android:color/system_neutral2_200</item>\n" +
                "<item name=\"paletteNeutralVariant70\">@android:color/system_neutral2_300</item>\n" +
                "<item name=\"paletteNeutralVariant60\">@android:color/system_neutral2_400</item>\n" +
                "<item name=\"paletteNeutralVariant50\">@android:color/system_neutral2_500</item>\n" +
                "<item name=\"paletteNeutralVariant40\">@android:color/system_neutral2_600</item>\n" +
                "<item name=\"paletteNeutralVariant30\">@android:color/system_neutral2_700</item>\n" +
                "<item name=\"paletteNeutralVariant20\">@android:color/system_neutral2_800</item>\n" +
                "<item name=\"paletteNeutralVariant10\">@android:color/system_neutral2_900</item>\n" +
                "<item name=\"paletteNeutralVariant0\">@android:color/system_neutral2_1000</item>\n";

        beginStyle(String.format(lightThemeNameFormat, nameUpperCamel), parentLightThemeName);
        print("<item name=\"colorPrimary\">@color/m3_sys_color_dynamic_light_primary</item>\n" +
                "<item name=\"colorOnPrimary\">@color/m3_sys_color_dynamic_light_on_primary</item>\n" +
                "<item name=\"colorPrimaryInverse\">@color/m3_sys_color_dynamic_light_inverse_primary</item>\n" +
                "<item name=\"colorPrimaryContainer\">@color/m3_sys_color_dynamic_light_primary_container</item>\n" +
                "<item name=\"colorOnPrimaryContainer\">@color/m3_sys_color_dynamic_light_on_primary_container</item>\n" +
                "<item name=\"colorPrimaryFixed\">@color/m3_sys_color_dynamic_primary_fixed</item>\n" +
                "<item name=\"colorPrimaryFixedDim\">@color/m3_sys_color_dynamic_primary_fixed_dim</item>\n" +
                "<item name=\"colorOnPrimaryFixed\">@color/m3_sys_color_dynamic_on_primary_fixed</item>\n" +
                "<item name=\"colorOnPrimaryFixedVariant\">@color/m3_sys_color_dynamic_on_primary_fixed_variant</item>\n" +
                "<item name=\"colorSecondary\">@color/m3_sys_color_dynamic_light_secondary</item>\n" +
                "<item name=\"colorOnSecondary\">@color/m3_sys_color_dynamic_light_on_secondary</item>\n" +
                "<item name=\"colorSecondaryContainer\">@color/m3_sys_color_dynamic_light_secondary_container</item>\n" +
                "<item name=\"colorOnSecondaryContainer\">@color/m3_sys_color_dynamic_light_on_secondary_container</item>\n" +
                "<item name=\"colorSecondaryFixed\">@color/m3_sys_color_dynamic_secondary_fixed</item>\n" +
                "<item name=\"colorSecondaryFixedDim\">@color/m3_sys_color_dynamic_secondary_fixed_dim</item>\n" +
                "<item name=\"colorOnSecondaryFixed\">@color/m3_sys_color_dynamic_on_secondary_fixed</item>\n" +
                "<item name=\"colorOnSecondaryFixedVariant\">@color/m3_sys_color_dynamic_on_secondary_fixed_variant</item>\n" +
                "<item name=\"colorTertiary\">@color/m3_sys_color_dynamic_light_tertiary</item>\n" +
                "<item name=\"colorOnTertiary\">@color/m3_sys_color_dynamic_light_on_tertiary</item>\n" +
                "<item name=\"colorTertiaryContainer\">@color/m3_sys_color_dynamic_light_tertiary_container</item>\n" +
                "<item name=\"colorOnTertiaryContainer\">@color/m3_sys_color_dynamic_light_on_tertiary_container</item>\n" +
                "<item name=\"colorTertiaryFixed\">@color/m3_sys_color_dynamic_tertiary_fixed</item>\n" +
                "<item name=\"colorTertiaryFixedDim\">@color/m3_sys_color_dynamic_tertiary_fixed_dim</item>\n" +
                "<item name=\"colorOnTertiaryFixed\">@color/m3_sys_color_dynamic_on_tertiary_fixed</item>\n" +
                "<item name=\"colorOnTertiaryFixedVariant\">@color/m3_sys_color_dynamic_on_tertiary_fixed_variant</item>\n" +
                "<item name=\"android:colorBackground\">@color/m3_sys_color_dynamic_light_background</item>\n" +
                "<item name=\"colorOnBackground\">@color/m3_sys_color_dynamic_light_on_background</item>\n" +
                "<item name=\"colorSurface\">@color/m3_sys_color_dynamic_light_surface</item>\n" +
                "<item name=\"colorOnSurface\">@color/m3_sys_color_dynamic_light_on_surface</item>\n" +
                "<item name=\"colorSurfaceVariant\">@color/m3_sys_color_dynamic_light_surface_variant</item>\n" +
                "<item name=\"colorOnSurfaceVariant\">@color/m3_sys_color_dynamic_light_on_surface_variant</item>\n" +
                "<item name=\"colorSurfaceInverse\">@color/m3_sys_color_dynamic_light_inverse_surface</item>\n" +
                "<item name=\"colorOnSurfaceInverse\">@color/m3_sys_color_dynamic_light_inverse_on_surface</item>\n" +
                "<item name=\"colorSurfaceBright\">@color/m3_sys_color_dynamic_light_surface_bright</item>\n" +
                "<item name=\"colorSurfaceDim\">@color/m3_sys_color_dynamic_light_surface_dim</item>\n" +
                "<item name=\"colorSurfaceContainer\">@color/m3_sys_color_dynamic_light_surface_container</item>\n" +
                "<item name=\"colorSurfaceContainerLow\">@color/m3_sys_color_dynamic_light_surface_container_low</item>\n" +
                "<item name=\"colorSurfaceContainerHigh\">@color/m3_sys_color_dynamic_light_surface_container_high</item>\n" +
                "<item name=\"colorSurfaceContainerLowest\">@color/m3_sys_color_dynamic_light_surface_container_lowest</item>\n" +
                "<item name=\"colorSurfaceContainerHighest\">@color/m3_sys_color_dynamic_light_surface_container_highest</item>\n" +
                "<item name=\"colorOutline\">@color/m3_sys_color_dynamic_light_outline</item>\n" +
                "<item name=\"colorOutlineVariant\">@color/m3_sys_color_dynamic_light_outline_variant</item>" +
                "<item name=\"colorError\">@color/m3_sys_color_light_error</item>\n" +
                "<item name=\"colorOnError\">@color/m3_sys_color_light_on_error</item>\n" +
                "<item name=\"colorErrorContainer\">@color/m3_sys_color_light_error_container</item>\n" +
                "<item name=\"colorOnErrorContainer\">@color/m3_sys_color_light_on_error_container</item>\n" +
                "<item name=\"android:textColorPrimary\">@color/m3_dynamic_default_color_primary_text</item>\n" +
                "<item name=\"android:textColorPrimaryInverse\">@color/m3_dynamic_dark_default_color_primary_text</item>\n" +
                "<item name=\"android:textColorSecondary\">@color/m3_dynamic_default_color_secondary_text</item>\n" +
                "<item name=\"android:textColorSecondaryInverse\">@color/m3_dynamic_dark_default_color_secondary_text</item>\n" +
                "<item name=\"android:textColorTertiary\">@color/m3_dynamic_default_color_secondary_text</item>\n" +
                "<item name=\"android:textColorTertiaryInverse\">@color/m3_dynamic_dark_default_color_secondary_text</item>\n" +
                "<item name=\"android:textColorPrimaryDisableOnly\">@color/m3_dynamic_primary_text_disable_only</item>\n" +
                "<item name=\"android:textColorPrimaryInverseDisableOnly\">@color/m3_dynamic_dark_primary_text_disable_only</item>\n" +
                "<item name=\"android:textColorHint\">@color/m3_dynamic_hint_foreground</item>\n" +
                "<item name=\"android:textColorHintInverse\">@color/m3_dynamic_dark_hint_foreground</item>\n" +
                "<item name=\"android:textColorHighlight\">@color/m3_dynamic_highlighted_text</item>\n" +
                "<item name=\"android:textColorHighlightInverse\">@color/m3_dynamic_dark_highlighted_text</item>\n" +
                "<item name=\"android:textColorAlertDialogListItem\">@color/m3_dynamic_default_color_primary_text</item>\n");

        // Extended colors
        for (MaterialThemeBuilderExtension.ExtendedColor extendedColor : extension.getExtendedColors()) {
            for (MaterialTheme.Color color : MaterialTheme.COLORS) {
                styleColorRef(
                        color.getAttributeName(extendedColor.getNameForAttribute()),
                        color.getFileName(nameLowerUnderScore, true, extendedColor.getNameForAttribute()));
            }
            style("harmonize" + extendedColor.getNameForAttribute(), Boolean.toString(extendedColor.isHarmonize()));
        }
        if (extension.isGeneratePalette()) {
            print(s);
        }
        if (extension.isGenerateTextColors()) {
            textColorStyles();
        }
        endStyle();

        beginStyle(String.format(darkThemeNameFormat, nameUpperCamel), parentDarkThemeName);
        print("<item name=\"colorPrimary\">@color/m3_sys_color_dynamic_dark_primary</item>\n" +
                "<item name=\"colorOnPrimary\">@color/m3_sys_color_dynamic_dark_on_primary</item>\n" +
                "<item name=\"colorPrimaryInverse\">@color/m3_sys_color_dynamic_dark_inverse_primary</item>\n" +
                "<item name=\"colorPrimaryContainer\">@color/m3_sys_color_dynamic_dark_primary_container</item>\n" +
                "<item name=\"colorOnPrimaryContainer\">@color/m3_sys_color_dynamic_dark_on_primary_container</item>\n" +
                "<item name=\"colorPrimaryFixed\">@color/m3_sys_color_dynamic_primary_fixed</item>\n" +
                "<item name=\"colorPrimaryFixedDim\">@color/m3_sys_color_dynamic_primary_fixed_dim</item>\n" +
                "<item name=\"colorOnPrimaryFixed\">@color/m3_sys_color_dynamic_on_primary_fixed</item>\n" +
                "<item name=\"colorOnPrimaryFixedVariant\">@color/m3_sys_color_dynamic_on_primary_fixed_variant</item>\n" +
                "<item name=\"colorSecondary\">@color/m3_sys_color_dynamic_dark_secondary</item>\n" +
                "<item name=\"colorOnSecondary\">@color/m3_sys_color_dynamic_dark_on_secondary</item>\n" +
                "<item name=\"colorSecondaryContainer\">@color/m3_sys_color_dynamic_dark_secondary_container</item>\n" +
                "<item name=\"colorOnSecondaryContainer\">@color/m3_sys_color_dynamic_dark_on_secondary_container</item>\n" +
                "<item name=\"colorSecondaryFixed\">@color/m3_sys_color_dynamic_secondary_fixed</item>\n" +
                "<item name=\"colorSecondaryFixedDim\">@color/m3_sys_color_dynamic_secondary_fixed_dim</item>\n" +
                "<item name=\"colorOnSecondaryFixed\">@color/m3_sys_color_dynamic_on_secondary_fixed</item>\n" +
                "<item name=\"colorOnSecondaryFixedVariant\">@color/m3_sys_color_dynamic_on_secondary_fixed_variant</item>\n" +
                "<item name=\"colorTertiary\">@color/m3_sys_color_dynamic_dark_tertiary</item>\n" +
                "<item name=\"colorOnTertiary\">@color/m3_sys_color_dynamic_dark_on_tertiary</item>\n" +
                "<item name=\"colorTertiaryContainer\">@color/m3_sys_color_dynamic_dark_tertiary_container</item>\n" +
                "<item name=\"colorOnTertiaryContainer\">@color/m3_sys_color_dynamic_dark_on_tertiary_container</item>\n" +
                "<item name=\"colorTertiaryFixed\">@color/m3_sys_color_dynamic_tertiary_fixed</item>\n" +
                "<item name=\"colorTertiaryFixedDim\">@color/m3_sys_color_dynamic_tertiary_fixed_dim</item>\n" +
                "<item name=\"colorOnTertiaryFixed\">@color/m3_sys_color_dynamic_on_tertiary_fixed</item>\n" +
                "<item name=\"colorOnTertiaryFixedVariant\">@color/m3_sys_color_dynamic_on_tertiary_fixed_variant</item>\n" +
                "<item name=\"android:colorBackground\">@color/m3_sys_color_dynamic_dark_background</item>\n" +
                "<item name=\"colorOnBackground\">@color/m3_sys_color_dynamic_dark_on_background</item>\n" +
                "<item name=\"colorSurface\">@color/m3_sys_color_dynamic_dark_surface</item>\n" +
                "<item name=\"colorOnSurface\">@color/m3_sys_color_dynamic_dark_on_surface</item>\n" +
                "<item name=\"colorSurfaceVariant\">@color/m3_sys_color_dynamic_dark_surface_variant</item>\n" +
                "<item name=\"colorOnSurfaceVariant\">@color/m3_sys_color_dynamic_dark_on_surface_variant</item>\n" +
                "<item name=\"colorSurfaceInverse\">@color/m3_sys_color_dynamic_dark_inverse_surface</item>\n" +
                "<item name=\"colorOnSurfaceInverse\">@color/m3_sys_color_dynamic_dark_inverse_on_surface</item>\n" +
                "<item name=\"colorSurfaceBright\">@color/m3_sys_color_dynamic_dark_surface_bright</item>\n" +
                "<item name=\"colorSurfaceDim\">@color/m3_sys_color_dynamic_dark_surface_dim</item>\n" +
                "<item name=\"colorSurfaceContainer\">@color/m3_sys_color_dynamic_dark_surface_container</item>\n" +
                "<item name=\"colorSurfaceContainerLow\">@color/m3_sys_color_dynamic_dark_surface_container_low</item>\n" +
                "<item name=\"colorSurfaceContainerHigh\">@color/m3_sys_color_dynamic_dark_surface_container_high</item>\n" +
                "<item name=\"colorSurfaceContainerLowest\">@color/m3_sys_color_dynamic_dark_surface_container_lowest</item>\n" +
                "<item name=\"colorSurfaceContainerHighest\">@color/m3_sys_color_dynamic_dark_surface_container_highest</item>\n" +
                "<item name=\"colorOutline\">@color/m3_sys_color_dynamic_dark_outline</item>\n" +
                "<item name=\"colorOutlineVariant\">@color/m3_sys_color_dynamic_dark_outline_variant</item>" +
                "<item name=\"colorError\">@color/m3_sys_color_dark_error</item>\n" +
                "<item name=\"colorOnError\">@color/m3_sys_color_dark_on_error</item>\n" +
                "<item name=\"colorErrorContainer\">@color/m3_sys_color_dark_error_container</item>\n" +
                "<item name=\"colorOnErrorContainer\">@color/m3_sys_color_dark_on_error_container</item>\n" +
                "<item name=\"android:textColorPrimary\">@color/m3_dynamic_dark_default_color_primary_text</item>\n" +
                "<item name=\"android:textColorPrimaryInverse\">@color/m3_dynamic_default_color_primary_text</item>\n" +
                "<item name=\"android:textColorSecondary\">@color/m3_dynamic_dark_default_color_secondary_text</item>\n" +
                "<item name=\"android:textColorSecondaryInverse\">@color/m3_dynamic_default_color_secondary_text</item>\n" +
                "<item name=\"android:textColorTertiary\">@color/m3_dynamic_dark_default_color_secondary_text</item>\n" +
                "<item name=\"android:textColorTertiaryInverse\">@color/m3_dynamic_default_color_secondary_text</item>\n" +
                "<item name=\"android:textColorPrimaryDisableOnly\">@color/m3_dynamic_dark_primary_text_disable_only</item>\n" +
                "<item name=\"android:textColorPrimaryInverseDisableOnly\">@color/m3_dynamic_primary_text_disable_only</item>\n" +
                "<item name=\"android:textColorHint\">@color/m3_dynamic_dark_hint_foreground</item>\n" +
                "<item name=\"android:textColorHintInverse\">@color/m3_dynamic_hint_foreground</item>\n" +
                "<item name=\"android:textColorHighlight\">@color/m3_dynamic_dark_highlighted_text</item>\n" +
                "<item name=\"android:textColorHighlightInverse\">@color/m3_dynamic_highlighted_text</item>\n" +
                "<item name=\"android:textColorAlertDialogListItem\">@color/m3_dynamic_dark_default_color_primary_text</item>\n");

        // Extended colors
        for (MaterialThemeBuilderExtension.ExtendedColor extendedColor : extension.getExtendedColors()) {
            for (MaterialTheme.Color color : MaterialTheme.COLORS) {
                styleColorRef(
                        color.getAttributeName(extendedColor.getNameForAttribute()),
                        color.getFileName(nameLowerUnderScore, false, extendedColor.getNameForAttribute()));
            }
            style("harmonize" + extendedColor.getNameForAttribute(), Boolean.toString(extendedColor.isHarmonize()));
        }
        if (extension.isGeneratePalette()) {
            print(s);
        }
        if (extension.isGenerateTextColors()) {
            textColorStyles();
        }
        endStyle();
    }

    private void writeExtendedColors(
            MaterialThemeBuilderExtension.ExtendedColor extendedColor,
            String nameLowerUnderScore) {

        if (!extendedColor.isHarmonize()) {
            return;
        }
        var extendedColorName = extendedColor.getNameForAttribute();
        var extendedColorInt = Integer.parseInt(extendedColor.getColor().replaceFirst("#", ""), 16);

        {
            var hctColor = Hct.fromInt(extendedColorInt);

            for (MaterialTheme.Color color : MaterialTheme.COLORS) {
                hctColor.setTone(color.getToneLight());
                color(hctColor.toInt(), color.getFileName(nameLowerUnderScore, true, extendedColorName));
            }
        }

        {
            var hctColor = Hct.fromInt(extendedColorInt);

            for (MaterialTheme.Color color : MaterialTheme.COLORS) {
                hctColor.setTone(color.getToneDark());
                color(hctColor.toInt(), color.getFileName(nameLowerUnderScore, false, extendedColorName));
            }
        }
    }

    private void writeTheme(MaterialThemeBuilderExtension.Theme theme) {
        if (!theme.isDynamicColors()) {
            return;
        }

        var name = Util.capitalize(Objects.requireNonNull(theme.getName(), "Name must not be null")
                .replaceAll("-", "_"));
        var lightThemeNameFormat = Optional.ofNullable(theme.getLightThemeFormat()).orElse("");
        var darkThemeNameFormat = Optional.ofNullable(theme.getDarkThemeFormat()).orElse("");
        var parentLightThemeName = Optional.ofNullable(theme.getLightThemeParent()).orElse("");
        var parentDarkThemeName = Optional.ofNullable(theme.getDarkThemeParent()).orElse("");

        String nameUpperCamel;
        String nameLowerUnderScore;
        var nameIsUnderScore = name.contains("_");
        if (nameIsUnderScore) {
            name = name.toLowerCase(Locale.ROOT);
            nameUpperCamel = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
            nameLowerUnderScore = name;
        } else {
            nameUpperCamel = name;
            nameLowerUnderScore = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
        }

        for (MaterialThemeBuilderExtension.ExtendedColor extendedColor : extension.getExtendedColors()) {
            writeExtendedColors(extendedColor, nameLowerUnderScore);
        }
        writeStylesForTheme(nameLowerUnderScore, nameUpperCamel, lightThemeNameFormat, parentLightThemeName, darkThemeNameFormat, parentDarkThemeName);
    }
}
