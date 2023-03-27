package variousClassUsageTest.extension;

import utility.random.CustomRandom;
import variousClassUsageTest.TestMember;
import variousClassUsageTest.TestProduct;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    //Arratlist는 일종의 배열입니다.
    //하지만 일반적인 배열과는 차이점을 가지고 잇습니다.
    //예로 0,1,2,3,4,5,6,6,6,9,10.........인 형태로 배열이 있습니다.
    //(뒤로 대략 100개의 정보가 더 존재합니다)

    // 숫자 6을 전부 지우고 뒤쪽에 9, 10을 앞으로 땡기고 싶다면 어떤 일이 발생할까요?
    // 고작 정보 3개를 지우기 위해 100개 분량의 데이터가 이동해야합니다.

    //그러므로 보다 효율성이 높은 방식이 있는데
    //아래와 같은 방식을 취하는 것입니다.

    //[0, 다음링크] -> [1, 다음링크] -> [2, 다음링크]-> [3, 다음링크]-> [4, 다음]-> [5, 다음]
    //-> [6, 다음]-> [6, 다음]-> [6, 다음]-> [7, 다음]->,,,,,,,
    //위 케이스에서 6을 정리하는 것은 아주 간단합니다.
    //[5, 다음]에서 다음을 [7, 다음]을 가르키도록 만들면 됩니다.
    //그럼 알아서 그사이에 있는[6, 다음] -> [6, 다음] ->[6, 다음] 정보는 동떨어집니다.
    // 100개의 데이터를 이동시키겠습니까?
    //아니면 그냥 연결되어 있는 링크선 하나 바꾸겠습니까?

    //사용방법
    //1. List<데이터타입>을 작성합니다.
    //2. 리스트 변수명을 적습니다.
    //3. new ArrayList<>();를 작성하여 리스트 객체를 생성합니다.
    List<TestMember> memberList;
    List<TestProduct> productList;

    public Manager() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    //랜덤한 이메일을 만들어줘여함
    //앞에 글자 4~8개 정도를 랜덤으로 뽑자
    //뒤에는 @test.com을 붙이도록한다.
    //5명 정도 만든다고 가정
    public void addRandomMember() {
        final int MAX_MEMBER_NUMBER = 5;

        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;

        for (int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            String tmpString = "";
            int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);
            for (int j = 0; j < MAX_EMAIL_LENGTH; j++) {
                tmpString += (char) CustomRandom.generateNumber('a', 'z');
            }

            //System.out.println(tmpString + "@test.com");
            memberList.add(new TestMember(
                    i, tmpString + "@test.com", "test"));

        }

    }

    public void printMemberList() {
        for (TestMember member : memberList) {
            System.out.println(member);
        }
    }
}