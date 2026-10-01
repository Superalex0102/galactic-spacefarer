namespace galactic;

type SpacesuitColor : String Enum {
    RED;
    BLUE;
    GREEN;
    YELLOW;
}

entity SpaceFarer {
    key ID : UUID;
    name : String(32);
    email: String(32);
    starductCollection : Integer;
    wormholeNavigationSkill : Integer;
    planet : Association to Planet;
    spaceSuitColor : SpacesuitColor;
    department : Association to Department;
    position : Association to Position;
}

entity Department {
    key ID : UUID;
    name : String(32);
}

entity Position {
    key ID : UUID;
    name : String(32);
}

entity Planet {
    key ID : UUID;
    name : String(32);
}