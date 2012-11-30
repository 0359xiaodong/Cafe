package com.example.demo.test;

import android.view.KeyEvent;
import android.widget.Button;

import com.baidu.cafe.CafeTestCase;
import com.baidu.cafe.local.Log;
import com.baidu.cafe.local.NetworkUtils;
import com.example.demo.MainActivity;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2012-6-27
 * @version
 * @todo
 */
public class TestCafe extends CafeTestCase<MainActivity> {

    public TestCafe() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * NOTICE: ����caseǰ��Ҫ����cafe_setup.bat
     */
    public void test_sample() {
        //local.beginRecordCode();
        assertTrue(false);
    }

    private void history() {
        Log.i("###", "" + new NetworkUtils().getPackageRcv("com.baidu.BaiduMap"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("###", "" + new NetworkUtils().getPackageRcv("com.baidu.BaiduMap"));
        remote.pressKey(KeyEvent.KEYCODE_HOME);
        //���������
        remote.pressKey(KeyEvent.KEYCODE_POWER);
        //���������
        remote.pressKey(KeyEvent.KEYCODE_VOLUME_DOWN);
        //����˵���
        remote.pressKey(KeyEvent.KEYCODE_MENU);
        //������ؼ�
        remote.pressKey(KeyEvent.KEYCODE_BACK);
        //���������
        remote.pressKey(KeyEvent.KEYCODE_SEARCH);
        //ж��sd��
        remote.unmount();
        //��װsd��
        remote.mount();
        //ɱ��̨����
        remote.killBackgroundProcesses("com.android.launcher");
        //��������Ӧ��
        remote.launchActivity("com.android.launcher");
        //�����ַ�
        local.enterText(0, "Cafe");//0��ʾ��һ��������
        //����
        //        local.clickLongOnView(fakeView);
        local.clickLongInList(1);
        local.clickLongOnText("Cafe");
        local.clickLongOnScreen(100, 100);
        //������֣��κοؼ��ϵ����֣�
        local.clickOnText("Cafe");
        //��ȡ�ؼ�
        local.getCurrentViews(Button.class);
        //��ȡlogcat
        String[] logs = remote.getLog();
        //��ȡ����
        remote.getBatteryLevel();
        //��ȡ����
        remote.getScreenBrightness();
        //��(0,0)�϶���(100,100)
        local.drag(0, 100, 0, 100, 10);
        //�Ŵ���С
        /**
         * zoom screen
         * 
         * @param start
         *            the start position e.g. new int[]{0,0,1,2}; means two
         *            pointers start at {0,0} and {1,2}
         * @param end
         *            the end position e.g. new int[]{100,110,200,220}; means
         *            two pointers end at {100,110} and {200,220}
         */
        local.zoom(new int[] { 0, 0, 1, 2 }, new int[] { 100, 110, 200, 220 });
        //����̵��
        remote.clickViewByText("ͨѶ¼");
        if (remote.waitForActivity("com.android.contacts.DialtactsContactsEntryActivity", 5000)) {
            Log.i("at com.android.contacts.DialtactsContactsEntryActivity");
        }
    }
}
