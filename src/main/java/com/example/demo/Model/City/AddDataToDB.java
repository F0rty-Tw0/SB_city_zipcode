package com.example.demo.Model.City;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddDataToDB {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(AddDataToDB.class);

    public void addData(String... strings) throws Exception {

        // log.info("Creating tables");

        // jdbcTemplate.execute("DROP TABLE IF EXISTS city");
        // jdbcTemplate.execute("CREATE TABLE city(" + "cityId SERIAL, cityZipCode INT,cityName VARCHAR(255))");

        // // Split up the array of whole names into an array of first/last names
        // List<Object[]> splitUpCity = Arrays.asList("05S55 Scanning", "0800 HøjeTaastrup", "0783 Facility",
        //         "0877 KøbenhavnC", "0892 SjællandUSFP", "0893 SjællandUSFB", "0894 Udbetaling", "0899 Kommuneservice",
        //         "0900 KøbenhavnC", "0910 KøbenhavnC", "0913 KøbenhavnsPakkecenter", "0914 KøbenhavnsPakkecenter",
        //         "0917 KøbenhavnsPakkecenter", "0918 KøbenhavnsPakkeBRC", "0919 ReturprintBRC", "0929 KøbenhavnC",
        //         "0960 InternationaltPostcenter", "0999 KøbenhavnC", "1001 KøbenhavnK", "1002 KøbenhavnK",
        //         "1003 KøbenhavnK", "1004 KøbenhavnK", "1005 KøbenhavnK", "1006 KøbenhavnK", "1007 KøbenhavnK",
        //         "1008 KøbenhavnK", "1009 KøbenhavnK", "1010 KøbenhavnK", "1011 KøbenhavnK", "1012 KøbenhavnK",
        //         "1013 KøbenhavnK", "1014 KøbenhavnK", "1015 KøbenhavnK", "1016 KøbenhavnK", "1017 KøbenhavnK",
        //         "1018 KøbenhavnK", "1019 KøbenhavnK", "1020 KøbenhavnK", "1021 KøbenhavnK", "1022 KøbenhavnK",
        //         "1023 KøbenhavnK", "1024 KøbenhavnK", "1025 KøbenhavnK", "1026 KøbenhavnK", "1045 KøbenhavnK",
        //         "1050 KøbenhavnK", "1051 KøbenhavnK", "1052 KøbenhavnK", "1053 KøbenhavnK", "1054 KøbenhavnK",
        //         "1055 KøbenhavnK", "1055 KøbenhavnK", "1056 KøbenhavnK", "1057 KøbenhavnK", "1058 KøbenhavnK",
        //         "1059 KøbenhavnK", "1060 KøbenhavnK", "1061 KøbenhavnK", "1062 KøbenhavnK", "1063 KøbenhavnK",
        //         "1064 KøbenhavnK", "1065 KøbenhavnK", "1066 KøbenhavnK", "1067 KøbenhavnK", "1068 KøbenhavnK",
        //         "1069 KøbenhavnK", "1070 KøbenhavnK", "1071 KøbenhavnK", "1072 KøbenhavnK", "1073 KøbenhavnK",
        //         "1074 KøbenhavnK", "1092 KøbenhavnK", "1093 KøbenhavnK", "1095 KøbenhavnK", "1098 KøbenhavnK",
        //         "1100 KøbenhavnK", "1101 KøbenhavnK", "1102 KøbenhavnK", "1103 KøbenhavnK", "1104 KøbenhavnK",
        //         "1105 KøbenhavnK", "1106 KøbenhavnK", "1107 KøbenhavnK", "1110 KøbenhavnK", "1111 KøbenhavnK",
        //         "1112 KøbenhavnK", "1113 KøbenhavnK", "1114 KøbenhavnK", "1115 KøbenhavnK", "1116 KøbenhavnK",
        //         "1117 KøbenhavnK", "1118 KøbenhavnK", "1119 KøbenhavnK", "1120 KøbenhavnK", "1121 KøbenhavnK",
        //         "1122 KøbenhavnK", "1123 KøbenhavnK", "1124 KøbenhavnK", "1125 KøbenhavnK", "1126 KøbenhavnK",
        //         "1127 KøbenhavnK", "1128 KøbenhavnK", "1129 KøbenhavnK", "1130 KøbenhavnK", "1131 KøbenhavnK",
        //         "1140 KøbenhavnK", "1147 KøbenhavnK", "1148 KøbenhavnK", "1150 KøbenhavnK", "1151 KøbenhavnK",
        //         "1152 KøbenhavnK", "1153 KøbenhavnK", "1154 KøbenhavnK", "1155 KøbenhavnK", "1156 KøbenhavnK",
        //         "1157 KøbenhavnK", "1158 KøbenhavnK", "1159 KøbenhavnK", "1160 KøbenhavnK", "1161 KøbenhavnK",
        //         "1162 KøbenhavnK", "1164 KøbenhavnK", "1165 KøbenhavnK", "1165 KøbenhavnK", "1166 KøbenhavnK",
        //         "1167 KøbenhavnK", "1168 KøbenhavnK", "1169 KøbenhavnK", "1170 KøbenhavnK", "1171 KøbenhavnK",
        //         "1172 KøbenhavnK", "1173 KøbenhavnK", "1174 KøbenhavnK", "1175 KøbenhavnK", "1200 KøbenhavnK",
        //         "1201 KøbenhavnK", "1202 KøbenhavnK", "1203 KøbenhavnK", "1204 KøbenhavnK", "1205 KøbenhavnK",
        //         "1206 KøbenhavnK", "1207 KøbenhavnK", "1208 KøbenhavnK", "1209 KøbenhavnK", "1210 KøbenhavnK",
        //         "1211 KøbenhavnK", "1212 KøbenhavnK", "1213 KøbenhavnK", "1214 KøbenhavnK", "1215 KøbenhavnK",
        //         "1216 KøbenhavnK", "1217 KøbenhavnK", "1218 KøbenhavnK", "1218 KøbenhavnK", "1218 KøbenhavnK",
        //         "1218 KøbenhavnK", "1218 KøbenhavnK", "1218 KøbenhavnK", "1219 KøbenhavnK", "1220 KøbenhavnK",
        //         "1221 KøbenhavnK", "1240 KøbenhavnK", "1250 KøbenhavnK", "1251 KøbenhavnK", "1252 KøbenhavnK",
        //         "1253 KøbenhavnK", "1254 KøbenhavnK", "1255 KøbenhavnK", "1256 KøbenhavnK", "1257 KøbenhavnK",
        //         "1259 KøbenhavnK", "1259 KøbenhavnK", "1260 KøbenhavnK", "1261 KøbenhavnK", "1263 KøbenhavnK",
        //         "1263 KøbenhavnK", "1264 KøbenhavnK", "1265 KøbenhavnK", "1266 KøbenhavnK", "1267 KøbenhavnK",
        //         "1268 KøbenhavnK", "1270 KøbenhavnK", "1271 KøbenhavnK", "1300 KøbenhavnK", "1301 KøbenhavnK",
        //         "1302 KøbenhavnK", "1303 KøbenhavnK", "1304 KøbenhavnK", "1306 KøbenhavnK", "1307 KøbenhavnK",
        //         "1307 KøbenhavnK", "1308 KøbenhavnK", "1309 KøbenhavnK", "1310 KøbenhavnK", "1311 KøbenhavnK",
        //         "1312 KøbenhavnK", "1313 KøbenhavnK", "1314 KøbenhavnK", "1315 KøbenhavnK", "1316 KøbenhavnK",
        //         "1317 KøbenhavnK", "1318 KøbenhavnK", "1319 KøbenhavnK", "1320 KøbenhavnK", "1321 KøbenhavnK",
        //         "1322 KøbenhavnK", "1323 KøbenhavnK", "1324 KøbenhavnK", "1325 KøbenhavnK", "1326 KøbenhavnK",
        //         "1327 KøbenhavnK", "1328 KøbenhavnK", "1329 KøbenhavnK", "1350 KøbenhavnK", "1352 KøbenhavnK",
        //         "1353 KøbenhavnK", "1354 KøbenhavnK", "1355 KøbenhavnK", "1356 KøbenhavnK", "1357 KøbenhavnK",
        //         "1358 KøbenhavnK", "1359 KøbenhavnK", "1359 KøbenhavnK", "1360 KøbenhavnK", "1361 KøbenhavnK",
        //         "1361 KøbenhavnK", "1362 KøbenhavnK", "1363 KøbenhavnK", "1364 KøbenhavnK", "1365 KøbenhavnK",
        //         "1366 KøbenhavnK", "1367 KøbenhavnK", "1368 KøbenhavnK", "1369 KøbenhavnK", "1370 KøbenhavnK",
        //         "1371 KøbenhavnK", "1400 KøbenhavnK", "1400 KøbenhavnK", "1401 KøbenhavnK", "1402 KøbenhavnK",
        //         "1402 KøbenhavnK", "1402 KøbenhavnK", "1402 KøbenhavnK", "1402 KøbenhavnK", "1403 KøbenhavnK",
        //         "1406 KøbenhavnK", "1407 KøbenhavnK", "1408 KøbenhavnK", "1409 KøbenhavnK", "1410 KøbenhavnK",
        //         "1411 KøbenhavnK", "1411 KøbenhavnK", "1412 KøbenhavnK", "1413 KøbenhavnK", "1414 KøbenhavnK",
        //         "1415 KøbenhavnK", "1416 KøbenhavnK", "1417 KøbenhavnK", "1418 KøbenhavnK", "1419 KøbenhavnK",
        //         "1420 KøbenhavnK", "1421 KøbenhavnK", "1422 KøbenhavnK", "1423 KøbenhavnK", "1424 KøbenhavnK",
        //         "1425 KøbenhavnK", "1426 KøbenhavnK", "1427 KøbenhavnK", "1428 KøbenhavnK", "1429 KøbenhavnK",
        //         "1430 KøbenhavnK", "1432 KøbenhavnK", "1432 KøbenhavnK", "1432 KøbenhavnK", "1433 KøbenhavnK",
        //         "1433 KøbenhavnK", "1433 KøbenhavnK", "1433 KøbenhavnK", "1433 KøbenhavnK", "1433 KøbenhavnK",
        //         "1433 KøbenhavnK", "1434 KøbenhavnK", "1434 KøbenhavnK", "1435 KøbenhavnK", "1436 KøbenhavnK",
        //         "1436 KøbenhavnK", "1436 KøbenhavnK", "1436 KøbenhavnK", "1436 KøbenhavnK", "1436 KøbenhavnK",
        //         "1437 KøbenhavnK", "1437 KøbenhavnK", "1437 KøbenhavnK", "1437 KøbenhavnK", "1437 KøbenhavnK",
        //         "1437 KøbenhavnK", "1437 KøbenhavnK", "1437 KøbenhavnK", "1437 KøbenhavnK", "1437 KøbenhavnK",
        //         "1437 KøbenhavnK", "1437 KøbenhavnK", "1438 KøbenhavnK", "1438 KøbenhavnK", "1438 KøbenhavnK",
        //         "1438 KøbenhavnK", "1438 KøbenhavnK", "1439 KøbenhavnK", "1439 KøbenhavnK", "1439 KøbenhavnK",
        //         "1439 KøbenhavnK", "1439 KøbenhavnK", "1439 KøbenhavnK", "1439 KøbenhavnK", "1439 KøbenhavnK",
        //         "1439 KøbenhavnK", "1439 KøbenhavnK", "1439 KøbenhavnK", "1439 KøbenhavnK", "1439 KøbenhavnK",
        //         "1439 KøbenhavnK", "1439 KøbenhavnK", "1440 KøbenhavnK", "1440 KøbenhavnK", "1440 KøbenhavnK",
        //         "1440 KøbenhavnK", "1440 KøbenhavnK", "1440 KøbenhavnK", "1440 KøbenhavnK", "1440 KøbenhavnK",
        //         "1440 KøbenhavnK", "1440 KøbenhavnK", "1440 KøbenhavnK", "1441 KøbenhavnK", "1441 KøbenhavnK",
        //         "1441 KøbenhavnK", "1448 KøbenhavnK", "1450 KøbenhavnK", "1451 KøbenhavnK", "1452 KøbenhavnK",
        //         "1453 KøbenhavnK", "1454 KøbenhavnK", "1455 KøbenhavnK", "1456 KøbenhavnK", "1457 KøbenhavnK",
        //         "1458 KøbenhavnK", "1459 KøbenhavnK", "1460 KøbenhavnK", "1461 KøbenhavnK", "1462 KøbenhavnK",
        //         "1463 KøbenhavnK", "1464 KøbenhavnK", "1465 KøbenhavnK", "1466 KøbenhavnK", "1467 KøbenhavnK",
        //         "1468 KøbenhavnK", "1470 KøbenhavnK", "1471 KøbenhavnK", "1472 KøbenhavnK", "1473 KøbenhavnK",
        //         "1500 KøbenhavnV", "1501 KøbenhavnV", "1502 KøbenhavnV", "1503 KøbenhavnV", "1504 KøbenhavnV",
        //         "1505 KøbenhavnV", "1506 KøbenhavnV", "1507 KøbenhavnV", "1508 KøbenhavnV", "1509 KøbenhavnV",
        //         "1510 KøbenhavnV", "1512 Returpost", "1513 FlytningerNogejtak", "1532 KøbenhavnV", "1533 KøbenhavnV",
        //         "1550 KøbenhavnV", "1550 KøbenhavnV", "1551 KøbenhavnV", "1552 KøbenhavnV", "1553 KøbenhavnV",
        //         "1553 KøbenhavnV", "1554 KøbenhavnV", "1555 KøbenhavnV", "1556 KøbenhavnV", "1557 KøbenhavnV",
        //         "1558 KøbenhavnV", "1559 KøbenhavnV", "1560 KøbenhavnV", "1561 KøbenhavnV", "1561 KøbenhavnV",
        //         "1562 KøbenhavnV", "1563 KøbenhavnV", "1564 KøbenhavnV", "1567 KøbenhavnV", "1568 KøbenhavnV",
        //         "1569 KøbenhavnV", "1570 KøbenhavnV", "1570 KøbenhavnV", "1571 KøbenhavnV", "1572 KøbenhavnV",
        //         "1573 KøbenhavnV", "1574 KøbenhavnV", "1575 KøbenhavnV", "1576 KøbenhavnV", "1577 KøbenhavnV",
        //         "1577 KøbenhavnV", "1577 KøbenhavnV", "1592 KøbenhavnV", "1599 KøbenhavnV", "1600 KøbenhavnV",
        //         "1601 KøbenhavnV", "1602 KøbenhavnV", "1603 KøbenhavnV", "1604 KøbenhavnV", "1605 KøbenhavnV",
        //         "1606 KøbenhavnV", "1607 KøbenhavnV", "1608 KøbenhavnV", "1609 KøbenhavnV", "1610 KøbenhavnV",
        //         "1611 KøbenhavnV", "1612 KøbenhavnV", "1613 KøbenhavnV", "1614 KøbenhavnV", "1615 KøbenhavnV",
        //         "1616 KøbenhavnV", "1617 KøbenhavnV", "1618 KøbenhavnV", "1619 KøbenhavnV", "1620 KøbenhavnV",
        //         "1620 KøbenhavnV", "1621 KøbenhavnV", "1622 KøbenhavnV", "1623 KøbenhavnV", "1624 KøbenhavnV",
        //         "1630 KøbenhavnV", "1631 KøbenhavnV", "1632 KøbenhavnV", "1633 KøbenhavnV", "1634 KøbenhavnV",
        //         "1635 KøbenhavnV", "1650 KøbenhavnV", "1651 KøbenhavnV", "1652 KøbenhavnV", "1653 KøbenhavnV",
        //         "1654 KøbenhavnV", "1655 KøbenhavnV", "1656 KøbenhavnV", "1657 KøbenhavnV", "1658 KøbenhavnV",
        //         "1659 KøbenhavnV", "1660 KøbenhavnV", "1660 KøbenhavnV", "1661 KøbenhavnV", "1662 KøbenhavnV",
        //         "1663 KøbenhavnV", "1664 KøbenhavnV", "1665 KøbenhavnV", "1666 KøbenhavnV", "1667 KøbenhavnV",
        //         "1668 KøbenhavnV", "1669 KøbenhavnV", "1670 KøbenhavnV", "1671 KøbenhavnV", "1671 KøbenhavnV",
        //         "1672 KøbenhavnV", "1673 KøbenhavnV", "1674 KøbenhavnV", "1675 KøbenhavnV", "1676 KøbenhavnV",
        //         "1677 KøbenhavnV", "1699 KøbenhavnV", "1700 KøbenhavnV", "1701 KøbenhavnV", "1702 KøbenhavnV",
        //         "1703 KøbenhavnV", "1704 KøbenhavnV", "1705 KøbenhavnV", "1706 KøbenhavnV", "1707 KøbenhavnV",
        //         "1708 KøbenhavnV", "1709 KøbenhavnV", "1710 KøbenhavnV", "1711 KøbenhavnV", "1711 KøbenhavnV",
        //         "1712 KøbenhavnV", "1714 KøbenhavnV", "1715 KøbenhavnV", "1716 KøbenhavnV", "1717 KøbenhavnV",
        //         "1718 KøbenhavnV", "1719 KøbenhavnV", "1720 KøbenhavnV", "1721 KøbenhavnV", "1722 KøbenhavnV",
        //         "1723 KøbenhavnV", "1724 KøbenhavnV", "1725 KøbenhavnV", "1726 KøbenhavnV", "1727 KøbenhavnV",
        //         "1728 KøbenhavnV", "1729 KøbenhavnV", "1730 KøbenhavnV", "1731 KøbenhavnV", "1732 KøbenhavnV",
        //         "1733 KøbenhavnV", "1734 KøbenhavnV", "1735 KøbenhavnV", "1736 KøbenhavnV", "1737 KøbenhavnV",
        //         "1738 KøbenhavnV", "1739 KøbenhavnV", "1749 KøbenhavnV", "1750 KøbenhavnV", "1751 KøbenhavnV",
        //         "1752 KøbenhavnV", "1753 KøbenhavnV", "1754 KøbenhavnV", "1755 KøbenhavnV", "1756 KøbenhavnV",
        //         "1757 KøbenhavnV", "1758 KøbenhavnV", "1759 KøbenhavnV", "1760 KøbenhavnV", "1761 KøbenhavnV",
        //         "1762 KøbenhavnV", "1763 KøbenhavnV", "1764 KøbenhavnV", "1765 KøbenhavnV", "1766 KøbenhavnV",
        //         "1770 KøbenhavnV", "1771 KøbenhavnV", "1772 KøbenhavnV", "1773 KøbenhavnV", "1774 KøbenhavnV",
        //         "1775 KøbenhavnV", "1777 KøbenhavnV", "1780 KøbenhavnV", "1782 KøbenhavnV", "1785 KøbenhavnV",
        //         "1786 KøbenhavnV", "1787 KøbenhavnV", "1790 KøbenhavnV", "1799 KøbenhavnV", "1799 KøbenhavnV",
        //         "1799 KøbenhavnV", "1799 KøbenhavnV", "1799 KøbenhavnV", "1799 KøbenhavnV", "1799 KøbenhavnV",
        //         "1799 KøbenhavnV", "1799 KøbenhavnV", "1799 KøbenhavnV", "1799 KøbenhavnV", "1799 KøbenhavnV",
        //         "1800 FrederiksbergC", "1801 FrederiksbergC", "1802 FrederiksbergC", "1803 FrederiksbergC",
        //         "1804 FrederiksbergC", "1805 FrederiksbergC", "1806 FrederiksbergC", "1807 FrederiksbergC",
        //         "1808 FrederiksbergC", "1809 FrederiksbergC", "1810 FrederiksbergC", "1811 FrederiksbergC",
        //         "1812 FrederiksbergC", "1813 FrederiksbergC", "1814 FrederiksbergC", "1815 FrederiksbergC",
        //         "1816 FrederiksbergC", "1817 FrederiksbergC", "1818 FrederiksbergC", "1819 FrederiksbergC",
        //         "1820 FrederiksbergC", "1822 FrederiksbergC", "1823 FrederiksbergC", "1824 FrederiksbergC",
        //         "1825 FrederiksbergC", "1826 FrederiksbergC", "1827 FrederiksbergC", "1828 FrederiksbergC",
        //         "1829 FrederiksbergC", "1835 FrederiksbergC", "1850 FrederiksbergC", "1851 FrederiksbergC",
        //         "1852 FrederiksbergC", "1853 FrederiksbergC", "1854 FrederiksbergC", "1855 FrederiksbergC",
        //         "1856 FrederiksbergC", "1857 FrederiksbergC", "1860 FrederiksbergC", "1861 FrederiksbergC",
        //         "1862 FrederiksbergC", "1863 FrederiksbergC", "1864 FrederiksbergC", "1865 FrederiksbergC",
        //         "1866 FrederiksbergC", "1867 FrederiksbergC", "1868 FrederiksbergC", "1870 FrederiksbergC",
        //         "1871 FrederiksbergC", "1872 FrederiksbergC", "1873 FrederiksbergC", "1874 FrederiksbergC",
        //         "1875 FrederiksbergC", "1876 FrederiksbergC", "1877 FrederiksbergC", "1878 FrederiksbergC",
        //         "1879 FrederiksbergC", "1900 FrederiksbergC", "1901 FrederiksbergC", "1902 FrederiksbergC",
        //         "1903 FrederiksbergC", "1904 FrederiksbergC", "1905 FrederiksbergC", "1906 FrederiksbergC",
        //         "1908 FrederiksbergC", "1909 FrederiksbergC", "1910 FrederiksbergC", "1911 FrederiksbergC",
        //         "1912 FrederiksbergC", "1913 FrederiksbergC", "1914 FrederiksbergC", "1915 FrederiksbergC",
        //         "1916 FrederiksbergC", "1917 FrederiksbergC", "1920 FrederiksbergC", "1921 FrederiksbergC",
        //         "1922 FrederiksbergC", "1923 FrederiksbergC", "1924 FrederiksbergC", "1925 FrederiksbergC",
        //         "1926 FrederiksbergC", "1927 FrederiksbergC", "1928 FrederiksbergC", "1931 FrederiksbergC",
        //         "1950 FrederiksbergC", "1951 FrederiksbergC", "1952 FrederiksbergC", "1953 FrederiksbergC",
        //         "1954 FrederiksbergC", "1955 FrederiksbergC", "1956 FrederiksbergC", "1957 FrederiksbergC",
        //         "1958 FrederiksbergC", "1959 FrederiksbergC", "1960 FrederiksbergC", "1961 FrederiksbergC",
        //         "1962 FrederiksbergC", "1963 FrederiksbergC", "1964 FrederiksbergC", "1965 FrederiksbergC",
        //         "1966 FrederiksbergC", "1967 FrederiksbergC", "1970 FrederiksbergC", "1971 FrederiksbergC",
        //         "1972 FrederiksbergC", "1973 FrederiksbergC", "1974 FrederiksbergC", "2000 Frederiksberg",
        //         "2100 KøbenhavnØ", "2150 Nordhavn", "2200 KøbenhavnN", "2300 KøbenhavnS", "2400 KøbenhavnNV",
        //         "2412 Grønland", "2450 KøbenhavnSV", "2500 Valby", "2600 Glostrup", "2605 Brøndby", "2610 Rødovre",
        //         "2620 Albertslund", "2625 Vallensbæk", "2630 Taastrup", "2635 Ishøj", "2640 Hedehusene",
        //         "2650 Hvidovre", "2660 BrøndbyStrand", "2665 VallensbækStrand", "2670 Greve", "2680 SolrødStrand",
        //         "2690 Karlslunde", "2700 Brønshøj", "2720 Vanløse", "2730 Herlev", "2740 Skovlunde", "2750 Ballerup",
        //         "2760 Måløv", "2765 Smørum", "2770 Kastrup", "2791 Dragør", "2800 KongensLyngby", "2820 Gentofte",
        //         "2830 Virum", "2840 Holte", "2850 Nærum", "2860 Søborg", "2870 Dyssegård", "2880 Bagsværd",
        //         "2900 Hellerup", "2920 Charlottenlund", "2930 Klampenborg", "2942 Skodsborg", "2950 Vedbæk",
        //         "2960 RungstedKyst", "2970 Hørsholm", "2980 Kokkedal", "2990 Nivå", "3000 Helsingør", "3050 Humlebæk",
        //         "3060 Espergærde", "3070 Snekkersten", "3080 Tikøb", "3100 Hornbæk", "3120 Dronningmølle",
        //         "3140 Ålsgårde", "3150 Hellebæk", "3200 Helsinge", "3210 Vejby", "3220 Tisvildeleje", "3230 Græsted",
        //         "3250 Gilleleje", "3300 Frederiksværk", "3310 Ølsted", "3320 Skævinge", "3330 Gørløse", "3360 Liseleje",
        //         "3370 Melby", "3390 Hundested", "3400 Hillerød", "3450 Allerød", "3460 Birkerød", "3480 Fredensborg",
        //         "3490 Kvistgård", "3500 Værløse", "3520 Farum", "3540 Lynge", "3550 Slangerup", "3600 Frederikssund",
        //         "3630 Jægerspris", "3650 Ølstykke", "3660 Stenløse", "3670 VeksøSjælland", "3700 Rønne",
        //         "3720 Aakirkeby", "3730 Nexø", "3740 Svaneke", "3751 Østermarie", "3760 Gudhjem", "3770 Allinge",
        //         "3782 Klemensker", "3790 Hasle", "4000 Roskilde", "4030 Tune", "4040 Jyllinge", "4050 Skibby",
        //         "4060 KirkeSåby", "4070 KirkeHyllinge", "4100 Ringsted", "4129 Ringsted", "4130 VibySjælland",
        //         "4140 Borup", "4160 Herlufmagle", "4171 Glumsø", "4173 Fjenneslev", "4174 JystrupMidtsj", "4180 Sorø",
        //         "4190 MunkeBjergby", "4200 Slagelse", "4220 Korsør", "4230 Skælskør", "4241 Vemmelev", "4242 Boeslunde",
        //         "4243 Rude", "4244 Agersø", "4245 Omø", "4250 Fuglebjerg", "4261 Dalmose", "4262 Sandved", "4270 Høng",
        //         "4281 Gørlev", "4291 RudsVedby", "4293 Dianalund", "4295 Stenlille", "4296 Nyrup", "4300 Holbæk",
        //         "4305 Orø", "4320 Lejre", "4330 Hvalsø", "4340 Tølløse", "4350 Ugerløse", "4360 KirkeEskilstrup",
        //         "4370 StoreMerløse", "4390 Vipperød", "4400 Kalundborg", "4420 Regstrup", "4440 Mørkøv", "4450 Jyderup",
        //         "4460 Snertinge", "4470 Svebølle", "4480 StoreFuglede", "4490 JerslevSjælland", "4500 NykøbingSj",
        //         "4520 Svinninge", "4532 Gislinge", "4534 Hørve", "4540 Fårevejle", "4550 Asnæs", "4560 Vig",
        //         "4571 Grevinge", "4572 NørreAsmindrup", "4573 Højby", "4581 Rørvig", "4583 SjællandsOdde",
        //         "4591 Føllenslev", "4592 Sejerø", "4593 Eskebjerg", "4600 Køge", "4621 Gadstrup", "4622 Havdrup",
        //         "4623 LilleSkensved", "4632 Bjæverskov", "4640 Faxe", "4652 Hårlev", "4653 Karise",
        //         "4654 FaxeLadeplads", "4660 StoreHeddinge", "4671 Strøby", "4672 Klippinge", "4673 RødvigStevns",
        //         "4681 Herfølge", "4682 Tureby", "4683 Rønnede", "4684 Holmegaard", "4690 Haslev", "4700 Næstved",
        //         "4720 Præstø", "4733 Tappernøje", "4735 Mern", "4736 Karrebæksminde", "4750 Lundby", "4760 Vordingborg",
        //         "4771 Kalvehave", "4772 Langebæk", "4773 Stensved", "4780 Stege", "4791 Borre", "4792 Askeby",
        //         "4793 BogøBy", "4800 NykøbingF", "4840 NørreAlslev", "4850 Stubbekøbing", "4862 Guldborg",
        //         "4863 Eskilstrup", "4871 Horbelev", "4872 Idestrup", "4873 Væggerløse", "4874 Gedser", "4880 Nysted",
        //         "4891 TorebyL", "4892 Kettinge", "4894 ØsterUlslev", "4895 Errindlev", "4900 Nakskov",
        //         "4912 Harpelunde", "4913 Horslunde", "4920 Søllested", "4930 Maribo", "4941 Bandholm",
        //         "4942 AskøogLilleø", "4943 TorrigL", "4944 Fejø", "4945 Femø", "4951 Nørreballe", "4952 Stokkemarke",
        //         "4953 Vesterborg", "4960 Holeby", "4970 Rødby", "4983 Dannemare", "4990 Sakskøbing",
        //         "4992 MidtsjællandUSFP", "5000 OdenseC", "5029 OdenseC", "5100 OdenseC", "5200 OdenseV",
        //         "5210 OdenseNV", "5220 OdenseSØ", "5230 OdenseM", "5240 OdenseNØ", "5250 OdenseSV", "5260 OdenseS",
        //         "5270 OdenseN", "5290 Marslev", "5300 Kerteminde", "5320 Agedrup", "5330 Munkebo", "5350 Rynkeby",
        //         "5370 Mesinge", "5380 Dalby", "5390 Martofte", "5400 Bogense", "5450 Otterup", "5462 Morud",
        //         "5463 Harndrup", "5464 BrenderupFyn", "5466 Asperup", "5471 Søndersø", "5474 Veflinge", "5485 Skamby",
        //         "5491 Blommenslyst", "5492 Vissenbjerg", "5500 Middelfart", "5540 Ullerslev", "5550 Langeskov",
        //         "5560 Aarup", "5580 NørreAaby", "5591 Gelsted", "5592 Ejby", "5600 Faaborg", "5601 Lyø",
        //         "5602 Avernakø", "5603 Bjørnø", "5610 Assens", "5620 Glamsbjerg", "5631 Ebberup", "5642 Millinge",
        //         "5672 Broby", "5683 Haarby", "5690 Tommerup", "5700 Svendborg", "5750 Ringe", "5762 VesterSkerninge",
        //         "5771 Stenstrup", "5772 Kværndrup", "5792 Årslev", "5800 Nyborg", "5853 Ørbæk", "5854 Gislev",
        //         "5856 Ryslinge", "5863 FerritslevFyn", "5871 Frørup", "5874 Hesselager", "5881 SkårupFyn",
        //         "5882 Vejstrup", "5883 Oure", "5884 Gudme", "5892 GudbjergSydfyn", "5900 Rudkøbing", "5932 Humble",
        //         "5935 Bagenkop", "5943 Strynø", "5953 Tranekær", "5960 Marstal", "5965 Birkholm", "5970 Ærøskøbing",
        //         "5985 SøbyÆrø", "6000 Kolding", "6040 Egtved", "6051 Almind", "6052 Viuf", "6064 Jordrup",
        //         "6070 Christiansfeld", "6091 Bjert", "6092 SønderStenderup", "6093 Sjølund", "6094 Hejls",
        //         "6100 Haderslev", "6200 Aabenraa", "6210 Barsø", "6230 Rødekro", "6240 Løgumkloster", "6261 Bredebro",
        //         "6270 Tønder", "6280 Højer", "6300 Gråsten", "6310 Broager", "6320 Egernsund", "6330 Padborg",
        //         "6340 Kruså", "6360 Tinglev", "6372 BylderupBov", "6392 Bolderslev", "6400 Sønderborg", "6430 Nordborg",
        //         "6440 Augustenborg", "6470 Sydals", "6500 Vojens", "6510 Gram", "6520 Toftlund", "6534 Agerskov",
        //         "6535 BranderupJ", "6541 Bevtoft", "6560 Sommersted", "6580 Vamdrup", "6600 Vejen", "6621 Gesten",
        //         "6622 Bække", "6623 Vorbasse", "6630 Rødding", "6640 Lunderskov", "6650 Brørup", "6660 Lintrup",
        //         "6670 Holsted", "6682 Hovborg", "6683 Føvling", "6690 Gørding", "6700 Esbjerg", "6701 Esbjerg",
        //         "6705 EsbjergØ", "6710 EsbjergV", "6715 EsbjergN", "6720 Fanø", "6731 Tjæreborg", "6740 Bramming",
        //         "6752 Glejbjerg", "6753 Agerbæk", "6760 Ribe", "6771 Gredstedbro", "6780 Skærbæk", "6792 Rømø",
        //         "6800 Varde", "6818 Årre", "6823 Ansager", "6830 NørreNebel", "6840 Oksbøl", "6851 JanderupVestj",
        //         "6852 Billum", "6853 VejersStrand", "6854 Henne", "6855 Outrup", "6857 Blåvand", "6862 Tistrup",
        //         "6870 Ølgod", "6880 Tarm", "6893 Hemmet", "6900 Skjern", "6920 Videbæk", "6933 Kibæk", "6940 LemSt",
        //         "6950 Ringkøbing", "6960 HvideSande", "6971 Spjald", "6973 Ørnhøj", "6980 Tim", "6990 Ulfborg",
        //         "7000 Fredericia", "7007 Fredericia", "7017 TaulovPakkecenter", "7018 PakkerTLP", "7029 Fredericia",
        //         "7080 Børkop", "7100 Vejle", "7120 VejleØst", "7130 Juelsminde", "7140 Stouby", "7150 Barrit",
        //         "7160 Tørring", "7171 Uldum", "7173 Vonge", "7182 Bredsten", "7183 Randbøl", "7184 Vandel",
        //         "7190 Billund", "7200 Grindsted", "7250 Hejnsvig", "7260 SønderOmme", "7270 Stakroge",
        //         "7280 SønderFelding", "7300 Jelling", "7321 Gadbjerg", "7323 Give", "7330 Brande", "7361 Ejstrupholm",
        //         "7362 Hampen", "7400 Herning", "7429 Herning", "7430 Ikast", "7441 Bording", "7442 Engesvang",
        //         "7451 Sunds", "7470 KarupJ", "7480 Vildbjerg", "7490 Aulum", "7500 Holstebro", "7540 Haderup",
        //         "7550 Sørvad", "7560 Hjerm", "7570 Vemb", "7600 Struer", "7620 Lemvig", "7650 Bøvlingbjerg",
        //         "7660 Bækmarksbro", "7673 Harboøre", "7680 Thyborøn", "7700 Thisted", "7730 Hanstholm", "7741 Frøstrup",
        //         "7742 Vesløs", "7752 Snedsted", "7755 BedstedThy", "7760 HurupThy", "7770 Vestervig", "7790 Thyholm",
        //         "7800 Skive", "7830 Vinderup", "7840 Højslev", "7850 StoholmJyll", "7860 Spøttrup", "7870 Roslev",
        //         "7884 Fur", "7900 NykøbingM", "7950 Erslev", "7960 Karby", "7970 RedstedM", "7980 Vils",
        //         "7990 ØsterAssels", "7992 SydjyllandFynUSFP", "7993 SydjyllandFynUSFB", "7996 Fakturaservice",
        //         "7997 Fakturascanning", "7998 Statsservice", "7999 Kommunepost", "8000 AarhusC", "8100 AarhusC",
        //         "8200 AarhusN", "8210 AarhusV", "8220 Brabrand", "8229 RisskovØ", "8230 Åbyhøj", "8240 Risskov",
        //         "8245 RisskovØ", "8250 Egå", "8260 VibyJ", "8270 Højbjerg", "8300 Odder", "8305 Samsø",
        //         "8310 TranbjergJ", "8320 Mårslet", "8330 Beder", "8340 Malling", "8350 Hundslund", "8355 Solbjerg",
        //         "8361 Hasselager", "8362 Hørning", "8370 Hadsten", "8380 Trige", "8381 Tilst", "8382 Hinnerup",
        //         "8400 Ebeltoft", "8410 Rønde", "8420 Knebel", "8444 Balle", "8450 Hammel", "8462 HarlevJ",
        //         "8464 Galten", "8471 Sabro", "8472 Sporup", "8500 Grenaa", "8520 Lystrup", "8530 Hjortshøj",
        //         "8541 Skødstrup", "8543 Hornslet", "8544 Mørke", "8550 Ryomgård", "8560 Kolind", "8570 Trustrup",
        //         "8581 Nimtofte", "8585 Glesborg", "8586 ØrumDjurs", "8592 Anholt", "8600 Silkeborg", "8620 Kjellerup",
        //         "8632 Lemming", "8641 Sorring", "8643 AnsBy", "8653 Them", "8654 Bryrup", "8660 Skanderborg",
        //         "8670 Låsby", "8680 Ry", "8700 Horsens", "8721 Daugård", "8722 Hedensted", "8723 Løsning",
        //         "8732 Hovedgård", "8740 Brædstrup", "8751 Gedved", "8752 Østbirk", "8762 Flemming", "8763 RaskMølle",
        //         "8765 Klovborg", "8766 NørreSnede", "8781 Stenderup", "8783 Hornsyld", "8789 Endelave", "8799 Tunø",
        //         "8800 Viborg", "8830 Tjele", "8831 Løgstrup", "8832 Skals", "8840 Rødkærsbro", "8850 Bjerringbro",
        //         "8860 Ulstrup", "8870 Langå", "8881 Thorsø", "8882 Fårvang", "8883 Gjern", "8900 RandersC",
        //         "8920 RandersNV", "8930 RandersNØ", "8940 RandersSV", "8950 Ørsted", "8960 RandersSØ",
        //         "8961 Allingåbro", "8963 Auning", "8970 Havndal", "8981 Spentrup", "8983 GjerlevJ", "8990 Fårup",
        //         "9000 Aalborg", "9029 Aalborg", "9100 Aalborg", "9200 AalborgSV", "9210 AalborgSØ", "9220 AalborgØst",
        //         "9230 SvenstrupJ", "9240 Nibe", "9260 Gistrup", "9270 Klarup", "9280 Storvorde", "9293 Kongerslev",
        //         "9300 Sæby", "9310 Vodskov", "9320 Hjallerup", "9330 Dronninglund", "9340 Asaa", "9352 Dybvad",
        //         "9362 Gandrup", "9370 Hals", "9380 Vestbjerg", "9381 Sulsted", "9382 Tylstrup", "9400 Nørresundby",
        //         "9430 Vadum", "9440 Aabybro", "9460 Brovst", "9480 Løkken", "9490 Pandrup", "9492 Blokhus",
        //         "9493 Saltum", "9500 Hobro", "9510 Arden", "9520 Skørping", "9530 Støvring", "9541 Suldrup",
        //         "9550 Mariager", "9560 Hadsund", "9574 Bælum", "9575 Terndrup", "9600 Aars", "9610 Nørager",
        //         "9620 Aalestrup", "9631 Gedsted", "9632 Møldrup", "9640 Farsø", "9670 Løgstør", "9681 Ranum",
        //         "9690 Fjerritslev", "9700 Brønderslev", "9740 JerslevJ", "9750 Østervrå", "9760 Vrå", "9800 Hjørring",
        //         "9830 Tårs", "9850 Hirtshals", "9870 Sindal", "9881 Bindslev", "9900 Frederikshavn", "9940 Læsø",
        //         "9970 Strandby", "9981 Jerup", "9982 Ålbæk", "9990 Skagen", "9992 JyllandUSFP", "9993 JyllandUSFB",
        //         "9996 Fakturaservice", "9997 Fakturascanning", "9998 Borgerservice", "2412 SantaClaus/Julemanden",
        //         "3900 Nuuk", "3905 Nuussuaq", "3910 Kangerlussuaq", "3911 Sisimiut", "3912 Maniitsoq", "3913 Tasiilaq",
        //         "3915 Kulusuk", "3919 AlluitsupPaa", "3920 Qaqortoq", "3921 Narsaq", "3922 Nanortalik",
        //         "3923 Narsarsuaq", "3924 Ikerasassuaq", "3930 Kangilinnguit", "3932 Arsuk", "3940 Paamiut",
        //         "3950 Aasiaat", "3951 Qasigiannguit", "3952 Ilulissat", "3953 Qeqertarsuaq", "3955 Kangaatsiaq",
        //         "3961 Uummannaq", "3962 Upernavik", "3964 Qaarsut", "3970 Pituffik", "3971 Qaanaaq", "3972 StationNord",
        //         "3980 Ittoqqortoormiit", "3982 Mestersvig", "3984 Danmarkshavn", "3985 ConstablePynt",
        //         "3992 SlædepatruljeSirius", "100 Tórshavn", "110 Tórshavn", "160 Argir", "165 Argir", "175 Kirkjubøur",
        //         "176 Velbastadur", "177 SydradalurStreymoy", "178 Nordradalur", "180 Kaldbak", "185 Kaldbaksbotnur",
        //         "186 Sund", "187 Hvitanes", "188 Hoyvík", "210 Sandur", "215 Sandur", "220 Skálavík", "230 Húsavík",
        //         "235 Dalur", "236 Skarvanes", "240 Skopun", "260 Skúvoy", "270 Nólsoy", "280 Hestur", "285 Koltur",
        //         "286 StóraDimun", "330 Stykkid", "335 Leynar", "336 Skællingur", "340 Kvívík", "350 Vestmanna",
        //         "355 Vestmanna", "358 Válur", "360 Sandavágur", "370 Midvágur", "375 Midvágur", "380 Sørvágur",
        //         "385 Vatnsoyrar", "386 Bøur", "387 Gásadalur", "388 Mykines", "400 Oyrarbakki", "405 Oyrarbakki",
        //         "410 Kollafjørdur", "415 Oyrareingir", "416 Signabøur", "420 Hósvík", "430 Hvalvík", "435 Streymnes",
        //         "436 Saksun", "437 Nesvík", "438 Langasandur", "440 Haldarsvík", "445 Tjørnuvík", "450 Oyri",
        //         "460 Nordskáli", "465 Svináir", "466 Ljósá", "470 Eidi", "475 Funningur", "476 Gjógv",
        //         "477 Funningsfjørdur", "478 Elduvík", "480 Skáli", "485 Skálafjørdur", "490 Strendur",
        //         "494 InnanGlyvur", "495 Kolbanargjógv", "496 Morskranes", "497 Selatrad", "510 Gøta", "511 Gøtugjógv",
        //         "512 Nordragøta", "513 Sydrugøta", "515 Gøta", "520 Leirvík", "530 Fuglafjørdur", "535 Fuglafjørdur",
        //         "600 Saltangará", "610 Saltangará", "620 Runavík", "625 Glyvrar", "626 Lambareidi", "627 Lambi",
        //         "640 Rituvík", "645 Æduvík", "650 Toftir", "655 NesEysturoy", "656 Saltnes", "660 Søldarfjørdur",
        //         "665 Skipanes", "666 Gøtueidi", "690 Oyndarfjørdur", "695 Hellur", "700 Klaksvík", "710 Klaksvík",
        //         "725 Nordoyri", "726 Ánir", "727 Árnafjørdur", "730 Norddepil", "735 Depil", "736 Nordtoftir",
        //         "737 Múli", "740 Hvannasund", "750 Vidareidi", "765 Svinoy", "766 Kirkja", "767 Hattarvík", "780 Kunoy",
        //         "785 Haraldssund", "795 SydradalurKalsoy", "796 Húsar", "797 Mikladalur", "798 Trøllanes",
        //         "800 Tvøroyri", "810 Tvøroyri", "825 Frodba", "826 Trongisvágur", "827 Øravík", "850 Hvalba",
        //         "860 Sandvík", "870 Fámjin", "900 Vágur", "910 Vágur", "925 NesVágur", "926 Lopra", "927 Akrar",
        //         "928 Vikarbyrgi", "950 Porkeri", "960 Hov", "970 Sumba").stream().map(name -> name.split(" "))
        //         .collect(Collectors.toList());

        // // Use a Java 8 stream to print out each tuple of the list
        // splitUpCity.forEach(name -> log.info(String.format("Inserting city record for %s %s", name[0], name[1])));

        // // Uses JdbcTemplate's batchUpdate operation to bulk load data
        // jdbcTemplate.batchUpdate("INSERT INTO city(cityZipCode, cityName) VALUES (?,?)", splitUpCity);
    }
}