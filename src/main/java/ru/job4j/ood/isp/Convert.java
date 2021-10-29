package ru.job4j.ood.isp;
/* В данном случае в наследнике может не понадобиться один из конвертеров */
public interface Convert {
    double rubleToDollar();
    double dollarToRuble();
    double rubleToYuan();
    double YuanToRuble();
}
