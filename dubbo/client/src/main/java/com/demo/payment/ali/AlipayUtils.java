package com.demo.payment.ali;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayUtils {

    public static final String URL = "https://openapi.alipay.com/gateway.do";
    public static final String PC_METHOD = "alipay.trade.page.pay";//PC网页支付
    public static final String MP_METHOD = "alipay.trade.wap.pay";//手机网页支付
    public static final String APP_ID = "";
    public static final String APP_PRIVATE_KEY = "";
    public static final String FORMAT = "json";
    public static final String CHARSET = "UTF-8";
    public static final String ALIPAY_PUBLIC_KEY = "";
    public static final String SIGN_TYPE = "RSA2";
    public static final String SELLER_ID = "";
    public static final String PRODUCT_CODE = "alipay";
    public static final String PRODUCT_CODE_PC = "FAST_INSTANT_TRADE_PAY";


//	----------------------------------------------------------------------------------

    public static final String URL_TEST = "https://openapi.alipaydev.com/gateway.do";
    public static final String APP_ID_TEST = "2016080300159588";
    public static final String APP_PRIVATE_KEY_TEST =
            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCRdVO6hk2Vbk1Lp4nm2vImyDzvpMRVr5U44rKog" +
                    "UdEsqF98EEAJXgTUpFePEqqyFeYZMnytkdH34cnu753p9V7b2FqNIW2XxSHTjzCaNnrcbRqnKCEephR5L" +
                    "K91SINEWEaig2kHTZxSy/Fv+Ou04R1LWRK+yVGHKY+6Xh0Ve5OgUC2IOO+4rEczQU2G9LSkR1Su02iWct" +
                    "kJBesVtB51RTqFW9NQ4VIlWoQdDaDqf3yVrAtFtmQnYsDIQtt0Sm4xQdZraTB2is9horbXmsdASBaxvvr" +
                    "Da/KKWwNu9zfJIj+fJi1YUNgzapgz8FCw4TtoD9k0msEOXg2akNPseva3KC5AgMBAAECggEAPdZIGxK/Z" +
                    "th2icQWzwqjSTN1HFfKk7bKVF2joBkdiCn8l4KMz5gePPCsFgjBoWr8OjAW3lT5ZqezWIPrDAlQq2IFYt" +
                    "YjRg2Tt5XeJLPYeMxk67HcV5Wara3xAtzZ1f5ebp7j/7HflDhnfcT+8TLAq+P5MBsmlHDXiAVPDP3/CmY" +
                    "kLCLtM+4ojzukjRPYsPz0ePBtXHgHGIlLfRxcnSUnhuS6tlVz3OcdZqyatlqmUFqDD8tCxMKWw1i+6D2j" +
                    "4aIHWggdO4URSGEku9xUW8JO90n56NR9AiBHC9S1VXClYVsjdSBLtGxeuGQql+WmJZvdMqZyXAMHSZ+8d" +
                    "0mMam6VgQKBgQD9zUTTxIXpZyH8NIazqyqm9iWXyHty7O2mshgM7qXQiqMiKNupGk0RvhLYIL8bOVdVcB" +
                    "ieRqMZydT10anNT+HrE5wb52tvIUT4jE1+E78ozW1DmKIbFOLb14T4yMlJzBdt85Gu0HuCXg9TY4sm1Ic" +
                    "u7JcnIZowREknYcjjhzdByQKBgQCSt9aVPVyHC/k7JnYc27osna+g1oU2U0g630A1fpSG7KvCrjjZnStV" +
                    "jtmBIN4SHeN0VaNhSHovTmq1DsGryVIr8IKmw9zoCU47cOXBqBVeYk/sW6kB3uWT0mSji9AW0EHuUnLoL" +
                    "nHT38WvZPTG2np2wpszsOGliJl6LN6bORdfcQKBgQCHms1TeIU0F+6Immf+R04atxmO54dN+Flh33YKMt" +
                    "hVfD19WudCitLyz+Oxpo11NkX7WFFO/97VQImQbd2T3UKQH4IhRpyYW+ZGBnDBFDvmyRvAKiUy4w3y+Ew" +
                    "LwPwLeghqruD/zlSvayI1I9KNhLBV2gNI3SNM9q8/Y3e6WdykQQKBgHqRtmSLFKeFazrtELNfJRNs0HJP" +
                    "hI4z2R3FsECAdNibE4raPYge8zrQ0gg8Swlbis9/U7RL9jdbDW4g288Fqu4mSR/EdOIsE/04fdjg8Kke/" +
                    "KH6mSCE88ogdA7lGHxWkx3kJzasxk84nE/AyXTuxGw+e6YdWQUPLxiQL5ABi/MhAoGAKZqvylzAHaJNEu" +
                    "J+IKza8IQ9CQDMG/AiFwjTee3TsoGK7cBm+2QOXHkxkIKjzzAr20szkiZi1espCuzesfWHKxEq0Jiom2Q" +
                    "6w1gzXg9h45KVeUsCMNgVlStCGb0N/KyJQPPTZU6EATpKnzegKnQ22idL5JRPbJw6vxIHjobaWqw=";
    public static final String FORMAT_TEST = "json";
    public static final String CHARSET_TEST = "UTF-8";
    public static final String ALIPAY_PUBLIC_KEY_TEST =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkXVTuoZNlW5NS6eJ5tryJsg876TEVa+VOOKyqIFHRLKhf" +
                    "fBBACV4E1KRXjxKqshXmGTJ8rZHR9+HJ7u+d6fVe29hajSFtl8Uh048wmjZ63G0apyghHqYUeSyvdUiDR" +
                    "FhGooNpB02cUsvxb/jrtOEdS1kSvslRhymPul4dFXuToFAtiDjvuKxHM0FNhvS0pEdUrtNolnLZCQXrFb" +
                    "QedUU6hVvTUOFSJVqEHQ2g6n98lawLRbZkJ2LAyELbdEpuMUHWa2kwdorPYaK215rHQEgWsb76w2vyils" +
                    "Dbvc3ySI/nyYtWFDYM2qYM/BQsOE7aA/ZNJrBDl4NmpDT7Hr2tyguQIDAQAB";
    public static final String SIGN_TYPE_TEST = "RSA2";
    public static final String SELLER_ID_TEST = "2088102169804553";
    public static final String PRODUCT_CODE_TEST = "QUICK_WAP_PAY";

    public static AlipayClient getInstance() {
//        return new DefaultAlipayClient(
//                AlipayUtils.URL_TEST,
//                AlipayUtils.APP_ID_TEST,
//                AlipayUtils.APP_PRIVATE_KEY_TEST,
//                AlipayUtils.FORMAT_TEST,
//                AlipayUtils.CHARSET_TEST,
//                AlipayUtils.ALIPAY_PUBLIC_KEY_TEST,
//                AlipayUtils.SIGN_TYPE_TEST);
        return new DefaultAlipayClient(
                AlipayUtils.URL,
                AlipayUtils.APP_ID,
                AlipayUtils.APP_PRIVATE_KEY,
                AlipayUtils.FORMAT,
                AlipayUtils.CHARSET,
                AlipayUtils.ALIPAY_PUBLIC_KEY,
                AlipayUtils.SIGN_TYPE);
    }

}
