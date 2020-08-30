package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxHeap {
	List<Integer> heap;
	
	public MaxHeap(int data) {
		heap = new ArrayList<Integer>();
        heap.add(null); //1�� �ε������� �����ϱ� ���� 0�� �迭�� null �� ����
        heap.add(data);
	}

        public void insert(int data) {
            heap.add(data); //Ʈ���� ������ ���� ������ ����
            int n = heap.size() - 1;
            
            // �θ���� �ڽ� ��� �� ��
            // �θ����� ���� �ڽ� ��� ���� ������
            // �θ���� �ڽ� ����� ��ġ ����
            while (n > 1 && heap.get(n / 2) < heap.get(n)) {
                int temp = heap.get(n / 2);
                
                heap.set(n / 2, heap.get(n));
                heap.set(n, temp);
                
                n = n / 2;
            }
            
        }
 
        //���� ū �� ����
        public int delete() {
            if (heap.size()-1 < 1)
                return 0;
            
            int deleteItem = heap.get(1); // ������ ��� = ��Ʈ���
 
            //��Ʈ ��忡 ���� ������ ��� ����
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1); //���� ������ ��� ����
 
            int node = 1;
            
            while ((node * 2) < heap.size()) {
            	
                int max = heap.get(node * 2);
                int childNode = node * 2;
 
                //������ �ڽ� ��� �̰�, ������ �ڽ� ����� ���� ���� �ڽ� ����� ��(max) ���� ũ�ٸ�
                if (((node * 2 + 1) < heap.size()) && max < heap.get(node * 2 + 1)) {
                	//�ִ밪 = ������ �ڽ� ����� ��
                	max = heap.get(node * 2 + 1);
                	childNode = node * 2 + 1;
                }
                //���� node�� ���� �ִ밪 ���� ũ�ٸ� 
                if (heap.get(node) > max)
                    break;
                
                // �θ����� ���� �ڽĳ�庸�� �۱� ������ �� ���� �� ��ȯ
                // �θ��� => �ڽ� ���
                // �ڽ� ��� => �θ���
                int tmp = heap.get(node);
                
                heap.set(node, heap.get(childNode));
                heap.set(childNode, tmp);
                node = childNode;
            }
 
            return deleteItem;
        }
    
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
 
        MaxHeap heap = new MaxHeap(n);
 
        for (int i = 0; i < n; i++) {
            int data = in.nextInt();
 
            if (data == 0) {
                System.out.println(heap.delete());
            } else {
                heap.insert(data);
            }
        }
 
    }

}