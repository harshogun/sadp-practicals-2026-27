# Chain of Responsibility — Loan Approval

## Aim
To implement the Chain of Responsibility Design Pattern for approving loan applications.

## Theory
The Chain of Responsibility Pattern passes a request through a sequence of handlers. Each handler decides whether to process the request or pass it to the next handler.

## Implementation
- `LoanApprover` defines the common handler abstraction and the next-handler reference.
- `Manager` approves loans up to Rs. 1,000.
- `SeniorManager` approves loans up to Rs. 10,000.
- `Director` approves loans up to Rs. 1,00,000.
- `Main` connects the handlers and submits loan requests.

## Conclusion
The Chain of Responsibility Pattern was implemented successfully. Loan requests are passed through the approval hierarchy until an eligible handler approves them or the request is rejected.