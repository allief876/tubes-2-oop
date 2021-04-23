package tubes;

import java.util.ArrayList;

public class Glalie extends Engimon{
    public Glalie(String name, Coordinate pos, int level) {
        super(name, "Glalie", "Ice", "none", "Kita doain kakak lulus tepat waktu", pos, level);
        ArrayList<String> element = new ArrayList<String>();
        element.add("Ice"); element.add("none");
        Elements.addAll(element);
        Skill newSkill = new Skill(element,90,1,"Freeze Shock");
        this.incSkills(newSkill);
    }
}