package tubes;

import java.util.ArrayList;

public class Diglett extends Engimon {
    public Diglett(String name, Coordinate pos, int level) {
        super(name, "Diglett", "Ground", "none", "Add UID genshin: 821919186", pos, level);
        ArrayList<String> element = new ArrayList<String>();
        element.add("Ground"); element.add("none");
        Elements.addAll(element);
        Skill newSkill = new Skill(element,115,1,"Max Quake");
        this.incSkills(newSkill);
    }
}