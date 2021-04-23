package tubes;

import java.util.ArrayList;

class Rotom extends Engimon{
    public Rotom(String name, Coordinate pos, int level) {
        super(name, "Rotom", "Fire", "Electric", "Siap begadang demi tubes", pos, level);
        ArrayList<String> element =  new ArrayList<String>();
        element.add("Fire"); element.add("Electric");
        Elements.addAll(element);
        Skill newSkill = new Skill(element,75,1,"Overloaded");
        this.incSkills(newSkill);
    }
}