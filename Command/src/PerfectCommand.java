/**
 * @author bngel
 * 更佳的命令模式模板
 */

abstract class PerfectCommand {

    protected final Receiver receiver;

    public PerfectCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}

class ConcreteCommand3 extends PerfectCommand {

    public ConcreteCommand3(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        super.receiver.doSomething();
    }

    public ConcreteCommand3() {
        super(new ConcreteReceiver1());
    }

}

class ConcreteCommand4 extends PerfectCommand {

    public ConcreteCommand4(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        super.receiver.doSomething();
    }

    public ConcreteCommand4() {
        super(new ConcreteReceiver2());
    }

}

class PerfectInvoker {

    private PerfectCommand command;

    public void setCommand(PerfectCommand command){
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }

}

class PerfectClient {

    public static void main(String[] args) {
        PerfectInvoker invoker = new PerfectInvoker();
        PerfectCommand command = new ConcreteCommand3();
        invoker.setCommand(command);
        invoker.action();
    }
}