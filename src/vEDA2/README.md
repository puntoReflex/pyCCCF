# Análisis del algoritmo

## Análisis de la estructura principal

```java
do {
    currentTime = currentTime + MINUTE;
    // Llegada de clientes - O(1)
    line = line + (Math.random() < PROBABILITY_ARRIVAL ? 1 : 0);
    
    // Procesamiento de cajas - 4 * O(1)
    if (line > 0 && customerService1 <= 0) {
        line = line - 1;
        customerService1 = createItems(ITEM_MAXIMUM, ITEM_MINIMUM);
    }
    // ... similar para cajas 2, 3, y 4

    // Visualización - O(k) donde k es número de clientes
    showHeader(currentTime, line);
    describeCustomerService(customerService1, 1);
    // ... similar para cajas 2, 3, y 4
} while (isWorking);
```

## Análisis de operaciones clave

### Manejo de tiempo

```java
currentTime = currentTime + MINUTE;     // O(1)
isWorking = currentTime < CLOSING_TIME; // O(1)
```

### Visualización

```java
ITEM.repeat(customerService) // O(k) donde k es número de ítems
CLIENT.repeat(line)          // O(m) donde m es longitud de la línea
```

## Análisis de complejidad

<div align=center>

||Teórica|Práctica|
|-|:-:|:-:|
|**Temporal**|O(n*k)|O(1)|
|**Espacial**|O(1)|O(1)|

</div>

> *n: número de minutos, k: máximo número de clientes*

## Consideraciones especiales

- Las operaciones de visualización son las más costosas.
- El sistema tiene límites naturales en el crecimiento de la línea.
- El tiempo total de simulación es fijo.
