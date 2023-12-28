package me.higherlevel.stackapi.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.StringArgument;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;

import java.util.ArrayList;
import java.util.List;

public class UnicodeCommand extends AbstractStackCommand {
    public UnicodeCommand() {
        super(new CommandAPICommand("unicode")
                .withArguments(new StringArgument("name").replaceSuggestions(ArgumentSuggestions.strings("ascii", "accented", "nonlatin")))
                .executesPlayer((sender, args) -> {
                    ComponentBuilder messageBuilder = Component.text();
                    List<String> lines = new ArrayList<>();
                    if (args.get("name").equals("ascii")) {
                        lines = List.of(("! \" # $ % & ' ( ) * + , - . /\n" +
                                "0 1 2 3 4 5 6 7 8 9 : ; < = > ?\n" +
                                "@ A B C D E F G H I J K L M N O\n" +
                                "P Q R S T U V W X Y Z [ \\ ] ^ _\n" +
                                "` a b c d e f g h i j k l m n o\n" +
                                "p q r s t u v w x y z { | } ~\n" +
                                "£ ƒ\n" +
                                "ª º ¬ « »\n" +
                                "░ ▒ ▓ │ ┤ ╡ ╢ ╖ ╕ ╣ ║ ╗ ╝ ╜ ╛ ┐\n" +
                                "└ ┴ ┬ ├ ─ ┼ ╞ ╟ ╚ ╔ ╩ ╦ ╠ ═ ╬ ╧\n" +
                                "╨ ╤ ╥ ╙ ╘ ╒ ╓ ╫ ╪ ┘ ┌ █ ▄ ▌ ▐ ▀\n" +
                                "∅ ∈\n" +
                                "≡ ± ≥ ≤ ⌠ ⌡ ÷ ≈ ° ∙ · √ ⁿ ² ■").split("\n"));
                    } else if (args.get("name").equals("accented")) {
                        lines = List.of(("À Á Â Ã Ä Å Æ Ç È É Ê Ë Ì Í Î Ï\n" +
                                "Ð Ñ Ò Ó Ô Õ Ö Ù Ú Û Ü Ý à á â ã\n" +
                                "ä å æ ç ì í î ï ñ ò ó ô õ ö ù ú\n" +
                                "û ü ý ÿ Ā ā Ă ă Ą ą Ć ć Ĉ ĉ Ċ ċ\n" +
                                "Č č Ď ď Đ đ Ē ē Ĕ ĕ Ė ė Ę ę Ě ě\n" +
                                "Ĝ ĝ Ḡ ḡ Ğ ğ Ġ ġ Ģ ģ Ĥ ĥ Ħ ħ Ĩ ĩ\n" +
                                "Ī ī Ĭ ĭ Į į İ ı Ĵ ĵ Ķ ķ Ĺ ĺ Ļ ļ\n" +
                                "Ľ ľ Ŀ ŀ Ł ł Ń ń Ņ ņ Ň ň Ŋ ŋ Ō ō\n" +
                                "Ŏ ŏ Ő ő Œ œ Ŕ ŕ Ŗ ŗ Ř ř Ś ś Ŝ ŝ\n" +
                                "Ş ş Š š Ţ ţ Ť ť Ŧ ŧ Ũ ũ Ū ū Ŭ ŭ\n" +
                                "Ů ů Ű ű Ų ų Ŵ ŵ Ŷ ŷ Ÿ Ź ź Ż ż Ž\n" +
                                "ž Ǽ ǽ Ǿ ǿ Ș ș Ț ț Ά Έ Ή Ί Ό Ύ Ώ\n" +
                                "ΐ Ϊ Ϋ ά έ ή ί ΰ ϊ ϋ ό ύ ώ Ѐ Ё Ѓ\n" +
                                "Ї Ќ Ѝ Ў Й й ѐ ё ђ ѓ ї ћ ќ ѝ ў џ\n" +
                                "Ґ ґ Ḃ ḃ Ḋ ḋ Ḟ ḟ Ḣ ḣ Ḱ ḱ Ṁ ṁ Ṗ ṗ\n" +
                                "Ṡ ṡ Ṫ ṫ Ẁ ẁ Ẃ ẃ Ẅ ẅ Ỳ ỳ è é ê ë\n" +
                                "ŉ ǧ ǫ Џ ḍ ḥ ṛ ṭ Ẓ Ị ị Ọ ọ Ụ ụ №\n" +
                                "ȇ Ɣ ɣ ʃ ⁇ Ǳ ǲ ǳ Ǆ ǅ ǆ Ǉ ǈ Ǌ ǋ ǌ\n" +
                                "ℹ ᵫ Ꜳ ꜳ Ꜵ ꜵ Ꜷ ꜷ Ꜹ Ꜻ Ꜽ ꜽ Ꝏ ꝏ Ꝡ ꝡ\n" +
                                "ﬄ ﬆ ᚡ ᚵ Ơ ơ Ư ư Ắ ắ Ấ ấ Ế ế ố Ớ\n" +
                                "ớ Ứ ứ Ằ ằ Ầ ầ Ề ề ồ Ờ ờ Ừ ừ Ả ả\n" +
                                "Ẳ ẳ Ẩ ẩ Ẻ ẻ ổ Ở Ể ể Ỉ ỉ Ỏ ỏ Ổ ở\n" +
                                "Ủ ủ Ử ử Ỷ ỷ Ạ ạ Ặ ặ Ậ ậ Ẹ ẹ Ệ ệ\n" +
                                "Ộ ộ Ợ ợ Ự ự Ỵ ỵ Ố ƕ Ẫ ẫ Ỗ ỗ ữ ☞\n" +
                                "☜ ☮ Ẵ ẵ Ẽ ẽ Ễ ễ Ồ Ỡ ỡ Ữ Ỹ ỹ Ҙ ҙ\n" +
                                "Ҡ ҡ Ҫ ҫ Ƕ ⚠ ⓪ ① ② ③ ④ ⑤ ⑥ ⑦ ⑧ ⑨\n" +
                                "⑩ ⑪ ⑫ ⑬ ⑭ ⑮ ⑯ ⑰ ⑱ ⑲ ⑳ Ⓐ Ⓑ Ⓒ Ⓓ Ⓔ\n" +
                                "Ⓕ Ⓖ Ⓗ Ⓘ Ⓙ Ⓚ Ⓛ Ⓜ Ⓝ Ⓞ Ⓟ Ⓠ Ⓡ Ⓢ Ⓣ Ⓤ\n" +
                                "Ⓥ Ⓦ Ⓧ Ⓨ Ⓩ ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ⓘ ⓙ ⓚ\n" +
                                "ⓛ ⓜ ⓝ ⓞ ⓟ ⓠ ⓡ ⓢ ⓣ ⓤ ⓥ ⓦ ⓧ ⓨ ⓩ ̧\n" +
                                "ʂ ʐ ɶ Ǎ ǎ Ǟ ǟ Ǻ ǻ Ȃ ȃ Ȧ ȧ Ǡ ǡ Ḁ\n" +
                                "ḁ Ȁ ȁ Ḇ ḇ Ḅ ḅ ᵬ Ḉ ḉ Ḑ ḑ Ḓ ḓ Ḏ ḏ\n" +
                                "Ḍ ᵭ Ḕ ḕ Ḗ ḗ Ḙ ḙ Ḝ ḝ Ȩ ȩ Ḛ ḛ Ȅ ȅ\n" +
                                "Ȇ ᵮ Ǵ ǵ Ǧ Ḧ ḧ Ḩ ḩ Ḫ ḫ Ȟ ȟ Ḥ ẖ Ḯ\n" +
                                "ḯ Ȋ ȋ Ǐ ǐ Ȉ ȉ Ḭ ḭ ǰ ȷ Ǩ ǩ Ḳ ḳ Ḵ\n" +
                                "ḵ Ḻ ḻ Ḽ ḽ Ḷ ḷ Ḹ ḹ Ɫ Ḿ ḿ Ṃ ṃ ᵯ Ṅ\n" +
                                "ṅ Ṇ ṇ Ṋ ṋ Ǹ ǹ Ṉ ṉ ᵰ Ǭ ǭ Ȭ ȭ Ṍ ṍ\n" +
                                "Ṏ ṏ Ṑ ṑ Ṓ ṓ Ȏ ȏ Ȫ ȫ Ǒ ǒ Ȯ ȯ Ȱ ȱ\n" +
                                "Ȍ ȍ Ǫ Ṕ ṕ ᵱ Ȓ ȓ Ṙ ṙ Ṝ ṝ Ṟ ṟ Ȑ ȑ\n" +
                                "Ṛ ᵳ ᵲ Ṥ ṥ Ṧ ṧ Ṣ ṣ Ṩ ṩ ᵴ Ṱ ṱ Ṯ ṯ\n" +
                                "Ṭ ẗ ᵵ Ṳ ṳ Ṷ ṷ Ṹ ṹ Ṻ ṻ Ǔ ǔ Ǖ ǖ Ǘ\n" +
                                "ǘ Ǚ ǚ Ǜ ǜ Ṵ ṵ Ȕ ȕ Ȗ Ṿ ṿ Ṽ ṽ Ẇ ẇ\n" +
                                "Ẉ ẉ ẘ Ẍ ẍ Ẋ ẋ Ȳ ȳ Ẏ ẏ ẙ Ẕ ẕ Ẑ ẑ\n" +
                                "ẓ ᵶ Ǯ ǯ ẛ Ꜿ ꜿ Ǣ ǣ ᵺ ỻ ᴂ ᴔ ꭣ ȸ ʣ\n" +
                                "ʥ ʤ ʩ ʪ ʫ ȹ ʨ ʦ ʧ ꭐ ꭑ ₧ Ỻ אַ אָ ƀ\n" +
                                "Ƃ ƃ Ƈ ƈ Ɗ Ƌ ƌ Ɠ Ǥ ǥ Ɨ Ɩ ɩ Ƙ ƙ Ɲ\n" +
                                "Ƥ ƥ ɽ Ʀ Ƭ ƭ ƫ Ʈ ȗ Ʊ Ɯ Ƴ ƴ Ƶ ƶ Ƣ\n" +
                                "ƣ Ȣ ȣ ʭ ʮ ʯ ﬔ ﬕ ﬗ ﬖ ﬓ Ӑ ӑ Ӓ ӓ Ӷ\n" +
                                "ӷ Ҕ ҕ Ӗ ӗ Ҽ ҽ Ҿ ҿ Ӛ ӛ Ӝ ӝ Ӂ ӂ Ӟ\n" +
                                "ӟ Ӣ ӣ Ӥ ӥ Ӧ ӧ Ӫ ӫ Ӱ ӱ Ӯ ӯ Ӳ ӳ Ӵ\n" +
                                "ӵ Ӹ ӹ Ӭ ӭ Ѷ ѷ Ӕ Ӻ Ԃ Ꚃ Ꚁ Ꚉ Ԫ Ԭ Ꚅ\n" +
                                "Ԅ Ԑ Ӡ Ԇ Ҋ Ӄ Ҟ Ҝ Ԟ Ԛ Ӆ Ԯ Ԓ Ԡ Ԉ Ԕ\n" +
                                "Ӎ Ӊ Ԩ Ӈ Ҥ Ԣ Ԋ Ҩ Ԥ Ҧ Ҏ Ԗ Ԍ Ꚑ Ҭ Ꚋ\n" +
                                "Ꚍ Ԏ Ҳ Ӽ Ӿ Ԧ Ꚕ Ҵ Ꚏ Ҷ Ӌ Ҹ Ꚓ Ꚗ Ꚇ Ҍ\n" +
                                "Ԙ Ԝ ӕ ӻ ԃ ꚃ ꚁ ꚉ ԫ ԭ ꚅ ԅ ԑ ӡ ԇ ҋ\n" +
                                "ӄ ҟ ҝ ԟ ԛ ӆ ԯ ԓ ԡ ԉ ԕ ӎ ӊ ԩ ӈ ҥ\n" +
                                "ԣ ԋ ҩ ԥ ҧ ҏ ԗ ԍ ꚑ ҭ ꚋ ꚍ ԏ ҳ ӽ ӿ\n" +
                                "ԧ ꚕ ҵ ꚏ ҷ ӌ ҹ ꚓ ꚗ ꚇ ҍ ԙ ԝ Ἀ ἀ Ἁ\n" +
                                "ἁ Ἂ ἂ Ἃ ἃ Ἄ ἄ Ἅ ἅ Ἆ ἆ Ἇ ἇ Ὰ ὰ Ᾰ\n" +
                                "ᾰ Ᾱ ᾱ Ά ά ᾈ ᾀ ᾉ ᾁ ᾊ ᾂ ᾋ ᾃ ᾌ ᾄ ᾍ\n" +
                                "ᾅ ᾎ ᾆ ᾏ ᾇ ᾼ ᾴ ᾶ ᾷ ᾲ ᾳ Ἐ ἐ Ἑ ἑ Ἒ\n" +
                                "ἒ Ἓ ἓ Ἔ ἔ Ἕ ἕ Ὲ Έ ὲ έ Ἠ ἠ Ὴ ὴ Ἡ\n" +
                                "ἡ Ἢ ἢ Ἣ ἣ Ἤ ἤ Ἥ ἥ Ἦ ἦ Ἧ ἧ ᾘ ᾐ ᾙ\n" +
                                "ᾑ ᾚ ᾒ ᾛ ᾓ ᾜ ᾔ ᾝ ᾕ ᾞ ᾖ ᾟ ᾗ Ή ή ῌ\n" +
                                "ῃ ῂ ῄ ῆ ῇ Ὶ ὶ Ί ί Ἰ ἰ Ἱ ἱ Ἲ ἲ Ἳ\n" +
                                "ἳ Ἴ ἴ Ἵ ἵ Ἶ ἶ Ἷ ἷ Ῐ ῐ Ῑ ῑ ῒ ΐ ῖ\n" +
                                "ῗ Ὸ ὸ Ό ό Ὀ ὀ Ὁ ὁ Ὂ ὂ Ὃ ὃ Ὄ ὄ Ὅ\n" +
                                "ὅ Ῥ ῤ ῥ Ὺ ὺ Ύ ύ Ὑ ὑ Ὓ ὓ Ὕ ὕ Ὗ ὗ\n" +
                                "Ῠ ῠ Ῡ ῡ ϓ ϔ ῢ ΰ ῧ ὐ ὒ ὔ ῦ ὖ Ὼ ὼ\n" +
                                "Ώ ώ Ὠ ὠ Ὡ ὡ Ὢ ὢ Ὣ ὣ Ὤ ὤ Ὥ ὥ Ὦ ὦ\n" +
                                "Ὧ ὧ ᾨ ᾠ ᾩ ᾡ ᾪ ᾢ ᾫ ᾣ ᾬ ᾤ ᾭ ᾥ ᾮ ᾦ\n" +
                                "ᾯ ᾧ ῼ ῳ ῲ ῴ ῶ ῷ ☯ ☐ ☑ ☒ ƍ ƺ Ȿ ȿ\n" +
                                "Ɀ ɀ ᶀ Ꞔ ꞔ ᶁ ᶂ ᶃ ꞕ ᶄ ᶅ ᶆ ᶇ ᶈ ᶉ ᶊ\n" +
                                "ᶋ ᶌ ᶍ Ᶎ ᶎ ᶏ ᶐ ᶒ ᶓ ᶔ ᶕ ᶖ ᶗ ᶘ ᶙ ᶚ\n" +
                                "ẚ ⅒ ⅘ ₨ ₯").split("\n"));
                    } else if (args.get("name").equals("nonlatin")) {
                        lines = List.of(("¡ ‰ \u00AD · ₴ ≠ ¿ × Ø Þ һ ð ø þ Α Β\n" +
                                "Γ Δ Ε Ζ Η Θ Ι Κ Λ Μ Ν Ξ Ο Π Ρ Σ\n" +
                                "Τ Υ Φ Χ Ψ Ω α β γ δ ε ζ η θ ι κ\n" +
                                "λ μ ν ξ ο π ρ ς σ τ υ φ χ ψ ω Ђ\n" +
                                "Ѕ І Ј Љ Њ Ћ А Б В Г Д Е Ж З И К\n" +
                                "Л М Н О П Р С Т У Ф Х Ц Ч Ш Щ Ъ\n" +
                                "Ы Ь Э Ю Я а б в г д е ж з и к л\n" +
                                "м н о п р с т у ф х ц ч ш щ ъ ы\n" +
                                "ь э ю я є ѕ і ј љ њ – — ‘ ’ “ ”\n" +
                                "„ … ⁊ ← ↑ → ↓ ⇄ ＋ Ə ə ɛ ɪ Ү ү Ө\n" +
                                "ө ʻ ˌ ; ĸ ẞ ß ₽ € Ѣ ѣ Ѵ ѵ Ӏ Ѳ ѳ\n" +
                                "⁰ ¹ ³ ⁴ ⁵ ⁶ ⁷ ⁸ ⁹ ⁺ ⁻ ⁼ ⁽ ⁾ ⁱ ™\n" +
                                "ʔ ʕ ⧈ ⚔ ☠ Қ қ Ғ ғ Ұ ұ Ә ә Җ җ Ң\n" +
                                "ң Һ א ב ג ד ה ו ז ח ט י כ ל מ ם\n" +
                                "נ ן ס ע פ ף צ ץ ק ר ¢ ¤ ¥ © ® µ\n" +
                                "¶ ¼ ½ ¾ · ‐ ‚ † ‡ • ‱ ′ ″ ‴ ‵ ‶\n" +
                                "‷ ‹ › ※ ‼ ‽ ⁂ ⁈ ⁉ ⁋ ⁎ ⁏ ⁑ ⁒ ⁗ ℗\n" +
                                "− ∓ ∞ ☀ ☁ ☈ Є ☲ ☵ ☽ ♀ ♂ ⚥ ♠ ♣ ♥\n" +
                                "♦ ♩ ♪ ♫ ♬ ♭ ♮ ♯ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ʬ ⚡\n" +
                                "⛏ ✔ ❄ ❌ ❤ ⭐ ⸘ ⸮ ⸵ ⸸ ⹁ ⹋ ⥝ ᘔ Ɛ ߈\n" +
                                "ϛ ㄥ Ɐ ᗺ Ɔ ᗡ Ǝ Ⅎ ⅁ Ʞ Ꞁ Ԁ Ꝺ ᴚ ⟘ ∩\n" +
                                "Ʌ ⅄ ɐ ɔ ǝ ɟ ᵷ ɥ ᴉ ɾ ʞ ꞁ ɯ ɹ ʇ ʌ\n" +
                                "ʍ ʎ Ա Բ Գ Դ Զ Է Թ Ժ Ի Լ Խ Ծ Կ Հ\n" +
                                "Ձ Ղ Ճ Մ Յ Ն Շ Ո Չ Ջ Ռ Ս Վ Տ Ր Ց\n" +
                                "Ւ Փ Ք Օ Ֆ ՙ ա բ գ դ ե զ է ը թ ժ\n" +
                                "ի լ խ ծ կ հ ձ ղ ճ մ յ ն շ ո չ պ\n" +
                                "ջ ռ ս վ տ ր ց ւ փ ք օ ֆ և ש ת Ը\n" +
                                "՚ ՛ ՜ ՝ ՞ ՟ ՠ ֈ ֏ ¯ ſ Ʒ ʒ Ƿ ƿ Ȝ\n" +
                                "ȝ Ȥ ȥ ˙ Ꝛ ꝛ ‑ ⅋ ⏏ ⏩ ⏪ ⏭ ⏮ ⏯ ⏴ ⏵\n" +
                                "⏶ ⏷ ⏸ ⏹ ⏺ ⏻ ⏼ ⏽ ⭘ ▲ ▶ ▼ ◀ ● ◦ ◘\n" +
                                "⚓ ⛨ Ĳ ĳ ǉ Ꜩ ꜩ ꜹ ꜻ ﬀ ﬁ ﬂ ﬃ ﬅ � Ե\n" +
                                "Պ ᚠ ᚢ ᚣ ᚤ ᚥ ᚦ ᚧ ᚨ ᚩ ᚪ ᚫ ᚬ ᚭ ᚮ ᚯ\n" +
                                "ᚰ ᚱ ᚲ ᚳ ᚴ ᚶ ᚷ ᚸ ᚹ ᚺ ᚻ ᚼ ᚽ ᚾ ᚿ ᛀ\n" +
                                "ᛁ ᛂ ᛃ ᛄ ᛅ ᛆ ᛇ ᛈ ᛉ ᛊ ᛋ ᛌ ᛍ ᛎ ᛏ ᛐ\n" +
                                "ᛑ ᛒ ᛓ ᛔ ᛕ ᛖ ᛗ ᛘ ᛙ ᛚ ᛛ ᛜ ᛝ ᛞ ᛟ ᛠ\n" +
                                "ᛡ ᛢ ᛣ ᛤ ᛥ ᛦ ᛧ ᛨ ᛩ ᛪ ᛫ ᛬ ᛭ ᛮ ᛯ ᛰ\n" +
                                "ᛱ ᛲ ᛳ ᛴ ᛵ ᛶ ᛷ ᛸ ☺ ☻ ¦ ☹ ך ׳ ״ װ\n" +
                                "ױ ײ ־ ׃ ׆ ´ ¨ ᴀ ʙ ᴄ ᴅ ᴇ ꜰ ɢ ʜ ᴊ\n" +
                                "ᴋ ʟ ᴍ ɴ ᴏ ᴘ ꞯ ʀ ꜱ ᴛ ᴜ ᴠ ᴡ ʏ ᴢ §\n" +
                                "ɱ ɳ ɲ ʈ ɖ ɡ ʡ ɕ ʑ ɸ ʝ ʢ ɻ ʁ ɦ ʋ\n" +
                                "ɰ ɬ ɮ ʘ ǀ ǃ ǂ ǁ ɓ ɗ ᶑ ʄ ɠ ʛ ɧ ɫ\n" +
                                "ɨ ʉ ʊ ɘ ɵ ɤ ɜ ɞ ɑ ɒ ɚ ɝ Ɓ Ɖ Ƒ Ʃ\n" +
                                "Ʋ Ⴀ Ⴁ Ⴂ Ⴃ Ⴄ Ⴅ Ⴆ Ⴇ Ⴈ Ⴉ Ⴊ Ⴋ Ⴌ Ⴍ Ⴎ\n" +
                                "Ⴏ Ⴐ Ⴑ Ⴒ Ⴓ Ⴔ Ⴕ Ⴖ Ⴗ Ⴘ Ⴙ Ⴚ Ⴛ Ⴜ Ⴝ Ⴞ\n" +
                                "Ⴟ Ⴠ Ⴡ Ⴢ Ⴣ Ⴤ Ⴥ Ⴧ Ⴭ ა ბ გ დ ე ვ ზ\n" +
                                "თ ი კ ლ მ ნ ო პ ჟ რ ს ტ უ ფ ქ ღ\n" +
                                "ყ შ ჩ ც ძ წ ჭ ხ ჯ ჰ ჱ ჲ ჳ ჴ ჵ ჶ\n" +
                                "ჷ ჸ ჹ ჺ ჻ ჼ ჽ ჾ ჿ תּ שׂ פֿ פּ כּ ײַ יִ\n" +
                                "וֹ וּ בֿ בּ ꜧ Ꜧ ɺ ⱱ ʠ ʗ ʖ ɭ ɷ ɿ ʅ ʆ\n" +
                                "ʓ ʚ ₪ ₾ ֊ ⴀ ⴁ ⴂ ⴃ ⴄ ⴅ ⴆ ⴡ ⴇ ⴈ ⴉ\n" +
                                "ⴊ ⴋ ⴌ ⴢ ⴍ ⴎ ⴏ ⴐ ⴑ ⴒ ⴣ ⴓ ⴔ ⴕ ⴖ ⴗ\n" +
                                "ⴘ ⴙ ⴚ ⴛ ⴜ ⴝ ⴞ ⴤ ⴟ ⴠ ⴥ ⅛ ⅜ ⅝ ⅞ ⅓\n" +
                                "⅔ ✉ ☂ ☔ ☄ ⛄ ☃ ⌛ ⌚ ⚐ ✎ ❣ ♤ ♧ ♡ ♢\n" +
                                "⛈ ☰ ☱ ☳ ☴ ☶ ☷ ↔ ⇒ ⇏ ⇔ ⇵ ∀ ∃ ∄ ∉\n" +
                                "∋ ∌ ⊂ ⊃ ⊄ ⊅ ∧ ∨ ⊻ ⊼ ⊽ ∥ ≢ ⋆ ∑ ⊤\n" +
                                "⊥ ⊢ ⊨ ≔ ∁ ∴ ∵ ∛ ∜ ∂ ⋃ ⊆ ⊇ □ △ ▷\n" +
                                "▽ ◁ ◆ ◇ ○ ◎ ☆ ★ ✘ ₀ ₁ ₂ ₃ ₄ ₅ ₆\n" +
                                "₇ ₈ ₉ ₊ ₋ ₌ ₍ ₎ ∫ ∮ ∝ ⌀ ⌂ ⌘ 〒 ɼ\n" +
                                "Ƅ ƅ ẟ Ƚ ƚ ƛ Ƞ ƞ Ɵ Ƨ ƨ ƪ Ƹ ƹ ƻ Ƽ\n" +
                                "ƽ ƾ ȡ ȴ ȵ ȶ Ⱥ ⱥ Ȼ ȼ Ɇ ɇ Ⱦ ⱦ Ɂ ɂ\n" +
                                "Ƀ Ʉ Ɉ ɉ Ɋ ɋ Ɍ ɍ Ɏ ɏ ẜ ẝ Ỽ ỽ Ỿ ỿ\n" +
                                "Ꞩ ꞩ \uD800\uDF30 \uD800\uDF31 \uD800\uDF32 \uD800\uDF33 \uD800\uDF34 \uD800\uDF35 \uD800\uDF36 \uD800\uDF37 \uD800\uDF38 \uD800\uDF39 \uD800\uDF3A \uD800\uDF3B \uD800\uDF3C \uD800\uDF3D\n" +
                                "\uD800\uDF3E \uD800\uDF3F \uD800\uDF40 \uD800\uDF41 \uD800\uDF42 \uD800\uDF43 \uD800\uDF44 \uD800\uDF45 \uD800\uDF46 \uD800\uDF47 \uD800\uDF48 \uD800\uDF49 \uD800\uDF4A \uD83C\uDF27 \uD83D\uDD25 \uD83C\uDF0A\n" +
                                "⅐ ⅑ ⅕ ⅖ ⅗ ⅙ ⅚ ⅟ ↉ \uD83D\uDDE1 \uD83C\uDFF9 \uD83E\uDE93 \uD83D\uDD31 \uD83C\uDFA3 \uD83E\uDDEA ⚗\n" +
                                "⯪ ⯫ Ɑ \uD83D\uDEE1 ✂ \uD83C\uDF56 \uD83E\uDEA3 \uD83D\uDD14 ⏳ ⚑ ₠ ₡ ₢ ₣ ₤ ₥\n" +
                                "₦ ₩ ₫ ₭ ₮ ₰ ₱ ₲ ₳ ₵ ₶ ₷ ₸ ₹ ₺ ₻\n" +
                                "₼ ₿").split("\n"));
                    }

                    for (String line : lines) {
                        String[] characters = line.split(" ");
                        for (String character : characters) {
                            if (!character.isEmpty()) {
                                messageBuilder.append(Component.text(character).hoverEvent(HoverEvent.showText(Component.text("Click to copy"))).clickEvent(ClickEvent.copyToClipboard(character)).append(Component.space()));
                            }
                        }
                        messageBuilder.append(Component.newline());
                    }
                    sender.sendMessage(messageBuilder.build());
                }));
    }
}
