package com.harsh.sadp.orders;

public class Main {

    public static void main(String[] args) {

        OrderValidator validator = new OrderValidator();
        PriceCalculator calculator = new PriceCalculator();

        OrderRepository repository = new ConsoleOrderRepository();
        EmailNotifier notifier = new ConsoleEmailNotifier();
        OrderLogger logger = new ConsoleOrderLogger();

        OrderProcessor processor = new OrderProcessor(
                validator,
                calculator,
                repository,
                notifier,
                logger
        );

        Order physicalOrder = new Order(
                "ORD-102",
                "customer@example.com",
                "physical",
                1000.0
        );

        OrderStrategy physicalStrategy =
                new PhysicalOrderStrategy();

        processor.process(physicalOrder, physicalStrategy);


    }
}
