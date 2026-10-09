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


        Order invalidOrder = new Order(
                "ORD-103",
                "customer@example.com",
                "digital",
                -100.0
        );

        try {
            processor.process(
                    invalidOrder,
                    new DigitalOrderStrategy()
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid order rejected: " + e.getMessage());
        }

        Order order = new Order(
                "ORD-104",
                "customer@example.com",
                "digital",
                1000.0
        );

        try {
            processor.process(order, new PhysicalOrderStrategy());
        } catch (IllegalArgumentException e) {
            System.out.println("Order rejected: " + e.getMessage());
        }
    }
}
