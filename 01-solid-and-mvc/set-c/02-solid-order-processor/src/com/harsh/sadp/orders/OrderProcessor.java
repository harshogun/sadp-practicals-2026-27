package com.harsh.sadp.orders;

public class OrderProcessor {

    private final OrderValidator validator;
    private final PriceCalculator priceCalculator;
    private final OrderRepository repository;
    private final EmailNotifier notifier;
    private final OrderLogger logger;

    public OrderProcessor(
            OrderValidator validator,
            PriceCalculator priceCalculator,
            OrderRepository repository,
            EmailNotifier notifier,
            OrderLogger logger) {

        this.validator = validator;
        this.priceCalculator = priceCalculator;
        this.repository = repository;
        this.notifier = notifier;
        this.logger = logger;
    }

    public void process(Order order, OrderStrategy strategy) {
        validator.validate(order);

        if (!order.getType().equalsIgnoreCase(strategy.getType())) {
            throw new IllegalArgumentException(
                    "Order type does not match strategy");
        }

        double total = priceCalculator.calculateTotal(order, strategy);

        repository.save(order, total);
        notifier.sendConfirmation(order, total);
        logger.log("Processed order " + order.getOrderId());
    }
}
