/**
 * @author bngel
 * 命令模式模板代码
 */

abstract class Receiver {
    public abstract void doSomething();
}

class ConcreteReceiver1 extends Receiver {
    @Override
    public void doSomething() {}
}

class ConcreteReceiver2 extends Receiver {
    @Override
    public void doSomething() { }
}

abstract class Command {
    public abstract void execute();
}

class ConcreteCommand1 extends Command {

    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}

class ConcreteCommand2 extends Command {

    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}

class Invoker {

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }

}

class Client {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver receiver = new ConcreteReceiver1();
        Command command = new ConcreteCommand1(receiver);
        invoker.setCommand(command);
        invoker.action();
    }

}
