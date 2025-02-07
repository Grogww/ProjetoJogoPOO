package game;

public class Arqueiro extends Personagem{

    public Arqueiro(String name){
        this.name = name;
        this.level = 1;
        specialUnlocked = false;
        hpBase = 26;
        powBase = 10;
        defBase = 4;
        resetStatus();
    }

    @Override
    public void attack(Personagem target) {
        System.out.println(name + " mira com seu arco e atira em " + target.name + "!");
        target.receiveDamage(pow);
    }

    @Override
    public void defend() {
        System.out.println(name + " se encolhe e se prepara para dseviar dos ataques!");
        def += defBase;
    }

    @Override
    public void useSpecial(Personagem target) {
        System.out.println(name + " puxa 3 flechas e mira com o arco, disparando uma rajada poderosa de projéteis!!!");
        target.receiveDamage(pow*2);
    }

    @Override
    public void levelUp(){
        level++;
        System.out.println(String.format("%s subiu para o nível %d.", name, level));;

        hpBase += 3;
        powBase += 3;
        defBase += 2;
        if(level  == 4){
            System.out.println("O poder especial da classe foi desbloqueado!");
            specialUnlocked = true;
        }

        resetStatus();
    }
}
