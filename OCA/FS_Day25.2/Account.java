class Account {
    private double amount;
    private String name;
    private long accountnumber;

    Account(double amount, String name, long accountnumber) {
        this.amount = amount;
        this.name = name;
        this.accountnumber = accountnumber;
    }

    public double getter_amount() {
        return amount;
    }

    public void setter_amount(double amount) {
        this.amount = amount;
    }

    public void setter_name(String name) {
        this.name = name;
    }

    public String getter_name(String name) {
        return name;
    }

    public long getter_account_num() {
        return accountnumber;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Account) && (((Account) obj).accountnumber == this.accountnumber)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "" + name + " has amount " + getter_amount() + " in account number " + accountnumber;
    }

    public static void main(String... args) {
        Account a1 = new Account(10000d, "kns", 1000200202l);
        Account a2 = new Account(19000d, "dasdas", 12020202020l);
        Account a3 = new Account(190001d, "dasdas4", 12020202020l);
        System.out.println(a1.equals(a2));
        System.out.println(a2.equals(a3));
        System.out.println(a1);
        int a[] = { 1, 4, 5 }, b[] = { 1, 2, 3, 4 };
        String[] a21 = { "grrr", "fsdfds" };
        System.out.println(a21.toString());
        System.out.println(b);
    }
}
