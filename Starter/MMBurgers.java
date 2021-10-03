import java.util.*;




class Node1{
	int id;
	int intime;
	int biltime;
	int burger=0;
	int bburger;
	int counterid;
	int rcbuger=0;
	int outtime;
	
	LinkedList<Node1> c5 = new LinkedList<>();
	Node1 left;
	Node1 right;
}
class Node2{
	int qs;
	int billtime;
	int id;
	int intime;
	int outtime;
	int rcbuger;
	int burger;
	int bburger;
	int counterid;
	LinkedList<Node2> c2 = new LinkedList<>();
	Node2 left;
	Node2 right;
	
}

class Node3{
	int griltime;
	LinkedList<burger> g = new LinkedList<>();
	Node3 left;
	Node3 right;
}
class burger{
	int grilltime;
	int customerid;
	int intime;
	int counterid;
	int delitime;
	int burger;
	int rcbuger;
}
 class Node{
	Queue<Node1> q = new LinkedList<>() ;
	int nodeId ;
	int counterid;
}
 class Heap{
	// MMBurgers mmb = new MMBurgers();
	 int k ;//= mmb.no_of_counter;
	 
	 Node[] arr ;
	 public Heap(int k){
		 this.k=k;
		 arr= new Node[k+1];
	 }
	 
	 
	 int currentsize = 0;
	 public void  man(){
//		 Node y = new Node();
//		 arr[0]= y;
		 for(int i=1; i<=k;i++){
			 Node newnode = new Node();
			 newnode.counterid =i;
			 newnode.nodeId = newnode.q.size();
			 if(isHeapEmpty()){
				 arr[1] = newnode;
				 currentsize++;
			 }
			 else{
				 arr[currentsize +1] = newnode;
				 currentsize++;
				 int p = currentsize;
				 while(arr[p].counterid < arr[pIndex(p)].counterid  ){
					// System.out.println("abc1");
					 swapup(p,pIndex(p));
					 p = pIndex(p);
					 if(p==1){
						 break;
					 }
				 }
			 }
			 
		 }
	 }
	 public boolean isHeapEmpty(){
		 return currentsize==0 ; 
	 }
	 public int pIndex(int index){
		 return index/2 ; 
	 }
	 public int rcIndex(int index){
		 return ((index*2) +1) ; 
	 }
	 public int lcIndex(int index){
		 return (index*2)  ;
	 }
	 public void swapup(int cindex1, int pindex2){
		 Node p= arr[cindex1];
		 arr[cindex1] = arr[pindex2];
		 arr[pindex2] = p;
	 }
	 public void swapdown(int pindex, int cindex){
		 Node p= arr[cindex];
		 arr[cindex] = arr[pindex];
		 arr[pindex] = p;
	 }
	 public void insert(Node1 node){
		      int topp=0;
			 arr[1].q.add(node);
			 topp= arr[1].q.size();
			 arr[1].nodeId = topp;
			 int b=1;
			 while(true)
			 { //System.out.println("abc2");
				 if( rcIndex(b)<=k && lcIndex(b)<=k){
				 if(arr[b].nodeId<arr[rcIndex(b)].nodeId && arr[b].nodeId<arr[lcIndex(b)].nodeId) {
					 break;
				 }
				 else if((arr[b].nodeId >(arr[rcIndex(b)].nodeId & arr[lcIndex(b)].nodeId))){
						if(arr[rcIndex(b)].nodeId>arr[lcIndex(b)].nodeId){
							swapdown(b,lcIndex(b));
							b=lcIndex(b);
						}
						else if(arr[rcIndex(b)].nodeId<arr[lcIndex(b)].nodeId){
							swapdown(b,rcIndex(b));
							b=rcIndex(b);
						}
						else{
							if(arr[rcIndex(b)].counterid<arr[lcIndex(b)].counterid){
								swapdown(b,rcIndex(b));
								b=rcIndex(b);
							}
							else{
								swapdown(b,lcIndex(b));
								b=lcIndex(b);
							}
						}
				  }
				  else if(arr[b].nodeId >arr[rcIndex(b)].nodeId && arr[b].nodeId <=arr[lcIndex(b)].nodeId){
						swapdown(b,rcIndex(b));
						b=rcIndex(b);
				  }
				  else if(arr[b].nodeId <=arr[rcIndex(b)].nodeId && arr[b].nodeId >arr[lcIndex(b)].nodeId){
						swapdown(b,lcIndex(b));
						b=lcIndex(b);
				  }
				  else {
				    	if((arr[b].counterid >(arr[rcIndex(b)].counterid & arr[lcIndex(b)].counterid))){
							if(arr[rcIndex(b)].counterid>arr[lcIndex(b)].counterid){
								swapdown(b,lcIndex(b));
								b=lcIndex(b);
							}
							else{
								swapdown(b,rcIndex(b));
								b=rcIndex(b);
							}
							
						}
				        else if(arr[b].counterid <arr[rcIndex(b)].counterid && arr[b].counterid >arr[lcIndex(b)].counterid){
							swapdown(b,lcIndex(b));
							b=lcIndex(b);
					    }
				    	else{
				    	
				    		swapdown(b,rcIndex(b));
				    		b=rcIndex(b);
				    	}
				    }
				 }
				 else{
					 if(arr[b].nodeId<arr[lcIndex(b)].nodeId){
						 break;
					 }
					 else if(arr[b].nodeId>arr[lcIndex(b)].nodeId){
						 swapdown(b,lcIndex(b));
						 b=lcIndex(b);
					 }
					 else{
						 if(arr[b].counterid<arr[lcIndex(b)].counterid){
							 break;
						 }
						 else {
							 swapdown(b,lcIndex(b));
							 b=lcIndex(b);
						 }
					 }
				 }
				 if(lcIndex(b)>k){
					 break;
				 }
				   //System.out.println(b); 
	 	     }
     }
 
	 public int delete(Node2 node){
		 int kk = node.counterid;
		// Node1 node1=null;
		 int ans=0;
		 int b=1;
		 while(b<=k){
			// System.out.println("abc3");
			 if(arr[b].counterid ==kk){
				// node = arr[b].q.element();
				 arr[b].q.remove();
				 ans=arr[b].q.size();
				 arr[b].nodeId = arr[b].q.size();
				 int t = b;
				 if(t!=1){
					 while(arr[t].nodeId <= arr[pIndex(t)].nodeId){
					//	 System.out.println("abc4");
						 
						 if(arr[t].nodeId < arr[pIndex(t)].nodeId){
							 swapup(t,pIndex(t));
							 t = pIndex(t);
						 }else if(arr[t].nodeId == arr[pIndex(t)].nodeId){
							 if(arr[t].counterid < arr[pIndex(t)].counterid){
								 swapup(t,pIndex(t));
								 t = pIndex(t);
							 }else{
								 break;
							 }
						 }else{
							 ;
						 }
						if(t==1){
							break;
						}
						//System.out.println("ab");
					 }
				}
				
				 break;
			 }
			 
			 b++;
			 //System.out.println("ab");
		 }
		 //return node1;
		 return ans;
	 }
	 public LinkedList<Node2> counterUpdate(int t, Bst2 b2){
		LinkedList<Node2> may = new LinkedList<Node2>();
		Node2 lal = b2.search(t);
		if(lal==null){
			;
		}
		else{
			may=lal.c2;
			b2.delete(t);
			for(int k=0;k<may.size();k++){
				
				int p=this.delete(may.get(k));
				may.get(k).qs=p;
			}
			
			
		}
		
		return may;
		 
	 }
 

	
 }
  class Bst1 {
		Node1 root;
		int currentsize =0;
		public void insert(Node1 node, Node1 r){
			
			if(root==null){
				root=node;
				currentsize++;
			}
			else{
				//Node1 temp=this.root;
				if(node.id<r.id){
					if(r.left!=null){
						this.insert(node, r.left);
					}
					else{
						r.left=node;
						currentsize++;
					}
				}
				else{
					if(r.right!=null){
						this.insert(node, r.right);
					}
					else{
						r.right=node;
						currentsize++;
					}
				}
			}
			//currentsize++;
		}
//       
		
		
		public boolean bins(burger bug){
			boolean an = false;
			int id = bug.customerid;
			Node1 temp =root;
			Node1 ans = null;
			if(root==null){
				ans = null;
			}
			
			while(temp!= null){
				if(id<temp.id){
					temp = temp.left;
				}else if(id>temp.id){
					temp= temp.right;
				}else if(id== temp.id) {
//		 			System.out.print("Yeah, Bst contains the value //searching by you !");
 					Node1 ut = new Node1();
//					int id;
//					int intime;
//					int biltime;
//					int burger=0;
//					int bburger;
//					int counterid;
//					int rcbuger=0;
//					int outtime;
//					
//					//LinkedList<Node1> c1 = new LinkedList<>();
//					Node1 left;
//					Node1 right;
					
					ut.id=temp.id;
					ut.intime=temp.intime;
					ut.biltime=temp.biltime;
					ut.burger=temp.burger;
					ut.counterid=temp.counterid;
					ut.rcbuger=temp.rcbuger+1;
					ut.outtime=temp.outtime;
					ut.left=temp.left;
					ut.right=temp.right;
					
					temp=ut;
					if(temp.rcbuger==temp.burger){
						an=true;
					}
					
		             
					break;
					
				}else{
					//System.out.print("Sorry, Bst doesn't contain the vlaue searching by you !");
					
					break;
				}
			}	
			 return an;
		}
//			
			
		public void add( Node1 node){
			if(this.search(node.id)==null){
				Node1 mak = node;
				mak.c5.add(node);
				this.insert(mak,this.root);
			}
			else{
				Node1 temp=this.root;
				while(temp!=null){
					if(temp.id==node.id){
						temp.c5.addFirst(node);
						break;
					}
					else if(temp.id<node.id){
						temp=temp.right;
					}
					else{
						temp=temp.left;
					}
				}
			}
		}
		
		public Node1 search(int id){
			Node1 temp =root;
			Node1 ans = null;
			if(root==null){
				ans = null;
			}
			
			while(temp!= null){
				if(id<temp.id){
					temp = temp.left;
				}else if(id>temp.id){
					temp= temp.right;
				}else if(id== temp.id) {
//		 			
		             ans = temp;
		             
					break;
					
				}else{
					
					
					break;
				}
			}	
			 return ans;
		}
		
//		
	public Node1 delete(Node1 rnode, int id){
		if(rnode==null){
			 return rnode;
		}else if(id<rnode.id){
			rnode.left=delete(rnode.left,  id);
		}else if(id>rnode.id){
			rnode.right=delete(rnode.right,  id);
		}else{
			if(rnode.left==null &&rnode.right!=null){
				rnode= rnode.right;
			}else if(rnode.right==null &&rnode.left!=null){
				rnode=rnode.left;
			}else if(rnode.right==null && rnode.left==null){
				rnode =null;
			}else{
				Node1 t= rnode.right;
			    while(t.left!=null){
			    //	System.out.println("abc6");
			        t = t.left;
			    }
			    int i = t.id;
			    rnode.id = i;
			    rnode.right = delete(rnode.right, rnode.id);
			   
			}
		}
		return rnode;
	}
	public void delete(int id){
		if(this.search(id)!=null){
		currentsize--;
		root= delete(root,id);
		}
		
		
	}
	


//		
		
		public boolean haveId( Node1 temp,int node){
			if(temp==null){
				return false;
			}if(node==temp.id){
				return true;
			}
			return node<temp.id
			? haveId(temp.left,node)
			:  haveId(temp.right,node);
		}
		public boolean haveId( int id){
			return haveId(root,id);
		}

	}
  
  class Bst2 {
		Node2 root;
      public Node2 create(Node2 rnode,Node2 node){
			 if(rnode==null){
				 return node; 
			 }
			 if(node.billtime<rnode.billtime){
				 rnode.left= create(rnode.left,node);
			 }else if(node.billtime>rnode.billtime){
				 rnode.right=create(rnode.right,node);
//			 }else{
//				 return rnode;
//			 }
			 }else if(node.billtime==rnode.billtime){
//			     Node newnode1 = new Node();
//			     newnode1.data = data;
//				 int qs;
//					int billtime;
//					int id;
//					int intime;
//					int outtime;
//					int rcbuger;
//					int burger;
//					int bburger;
//					int counterid;
//					LinkedList<Node2> c2 = new LinkedList<>();
//					Node2 left;
//					Node2 right;
				 Node2 ku = new Node2();
				 ku.qs=rnode.qs;
				 ku.billtime=rnode.billtime;
				 ku.id=rnode.id;
				 ku.intime=rnode.intime;
				 ku.outtime=rnode.outtime;
				 ku.rcbuger=rnode.rcbuger;
				 ku.burger=rnode.burger;
				 ku.counterid=rnode.counterid;
				 LinkedList<Node2> mm = rnode.c2;
				 mm.add(node);
				 ku.c2=mm;
				 ku.left=rnode.left;
				 ku.right=rnode.right;
				 
				 rnode=ku;
				 
				 
				 
				// rnode.c2.add(node);
			 }
			 return rnode;
			 
		}
		public void insertData(Node2 node){
			root=create(root,node);
		}
		
	public Node2 search(int billtime){
		Node2 ans = null;
		Node2 temp =root;
		if(root==null){
			 ans=null;
		}
		
		while(temp!= null){
			//System.out.println("abc1");
			if(billtime<temp.billtime){
				temp = temp.left;
			}else if(billtime>temp.billtime){
				temp= temp.right;
//			}else  {
//				ans=temp;
//				
//				break;
//				
//			}
//		}
			}else  {
				ans=temp;
				
				break;
				
			}
		}	
		return ans;
		 
		}
	public Node2 delete(Node2 rnode, int t){
		if(rnode==null){
			 return rnode;
		}else if(t<rnode.billtime){
			rnode.left=delete(rnode.left,  t);
		}else if(t>rnode.billtime){
			rnode.right=delete(rnode.right, t);
		}else{
			if(rnode.left==null &&rnode.right!=null){
				rnode= rnode.right;
			}else if(rnode.right==null &&rnode.left!=null){
				rnode=rnode.left;
			}else if(rnode.right==null && rnode.left==null){
				rnode =null;
			}else{
				Node2 l= rnode.right;
			    while(l.left!=null){
			    	//System.out.println("abc1");
			        l = l.left;
			    }
			    int i = l.billtime;
			    rnode.billtime = i;
			    rnode.right = delete(rnode.right, rnode.billtime);
			   
			}
		}
		return rnode;
	}
	public void delete(int  t){
		if(this.search(t)!=null){
			
		root= delete(root,t);
		}
		
	}


//		
//
	}
  
  
  
  class Bst3 {
	  int currentsize=0;
		Node3 root;
    public Node3 create(Node3 rnode,Node3 node){
			 if(rnode==null){
				 return node; 
			 }
			 if(node.griltime<rnode.griltime){
				 rnode.left= create(rnode.left,node);
			 }else if(node.griltime>rnode.griltime){
				 rnode.right=create(rnode.right,node);
			 }else{
				 return rnode;
			 }
			 return rnode;
			 
		}
		public void insertData(Node3 node){
			root=create(root,node);
			currentsize = currentsize + node.g.size();
		}
//		
		
		public Node3 search(int grilltime){
			Node3 ans = null;
			Node3 temp =root;
			if(root==null){
				ans =null ;
			}
			
			while(temp!= null){
			//	System.out.println("abc1");
				if(grilltime<temp.griltime){
					temp = temp.left;
				}else if(grilltime>temp.griltime){
					temp= temp.right;
				}else  {
					ans=temp;
					
					break;
					
				}
			}
			return ans;
			 
		}
	public Node3 delete(Node3 rnode, Node3 node){
	
		if(rnode==null){
			 return rnode;
		}else if(node.griltime<rnode.griltime){
			rnode.left=delete(rnode.left,  node);
		}else if(node.griltime>rnode.griltime){
			rnode.right=delete(rnode.right,  node);
		}else{
			if(rnode.left==null &&rnode.right!=null){
				rnode= rnode.right;
			}else if(rnode.right==null &&rnode.left!=null){
				rnode=rnode.left;
			}else if(rnode.right==null && rnode.left==null){
				rnode =null;
			}else{
				Node3 t= rnode.right;
			    while(t.left!=null){
			    //	System.out.println("abc1");
			        t = t.left;
			    }
			    int i = t.griltime;
			    rnode.griltime = i;
			    rnode.right = delete(rnode.right, rnode);
			   
			}
		}
		return rnode;
	}
	public void delete(Node3 node){
		if(this.search(node.griltime)!=null)
		{
		currentsize=currentsize-node.g.size();
		root= delete(root,node);
		}
		
	}


//		
}
class resturant{
	int no_of_counter;
    int no_of_burger_gc;
    Bst1 bs1 = new Bst1();
    Bst2 bs2 = new Bst2();
    Bst3 bs3 = new Bst3();
    Bst1 bs4 = new Bst1();
    Bst1 bs5 = new Bst1();
    LinkedList<Node1> lu = new LinkedList<Node1>();
   // int gtime =0;
    //static 
    Heap h ;
    //h.man();
    
   // h.k = this.no_of_counter ;
    LinkedList<Node2> mat = new LinkedList<Node2>();
    LinkedList<burger> bat = new LinkedList<burger>();
    LinkedList<Integer> awt =new LinkedList<Integer>();
    int p_=0;
    
       public boolean isEmpty(){
    	    boolean ans = bs1.currentsize==0;
    	    
//    	    if(bs1.root==null){
//    	    	ans=true;
//    	    }
     	//if(ans==false){
     	//System.out.println(bs1.root.rcbuger);
     	//}
     	//System.out.println(ans);
     //	bs1.inOrder(bs1.root);
     	//System.out.println(bs1.currentsize);
     	   return ans;
       }
        public void setK(int k) {
        
    	
    		   this.no_of_counter =k;
        	   h = new Heap(no_of_counter);
        	   h.man();
    	
    	
    	 }  
         
        
        public void setM(int m) {
            
        		this.no_of_burger_gc = m;
        } 
        
        public void counterUpdate(int gtime){
        	LinkedList<Node2> call = h.counterUpdate(gtime, bs2);
    		//Collections.sort(call, new SC());
    		Collections.sort(call, new Comparator<Node2>(){
    			@Override 
    			public int compare(Node2 n1, Node2 n2) {
    			
    					int ans=n2.counterid - n1.counterid;
    					return  ans;
    			}

    		});
    		for(int k=0;k<call.size();k++){
    			//System.out.println(call.get(k).counterid);
    			mat.add(call.get(k));
    		}
        }
        
        
        public void removingPatty(int gtime){
        	Node3 cc= bs3.search(gtime);
    		if(cc!=null){
    			bs3.delete(bs3.search(gtime));
        		for(int p=0;p<cc.g.size();p++){
        			//cc.g.get(p).delitime = cc.g.get(p).grilltime +1;
        			bat.add(cc.g.get(p));
        		}
        			
    		}
        }
        
        public void addingPatty(int gtime){
        	if(bs3.currentsize<this.no_of_burger_gc){
    			int diff = this.no_of_burger_gc-bs3.currentsize;
    			Node3 boj = new Node3();
    			boolean mak = false;
    			boj.griltime=gtime+10;
    			int k =0;
    			
    			while(diff>0){
    				//System.out.println("abcd");
    				if(!mat.isEmpty()){
    					mak=true;
    					if(p_==0){
    					 p_ = mat.get(0).burger;
    					}
    					if(diff==p_){
        					for(int m=0;m<diff;m++){
        						burger bug = new burger();
        						bug.customerid=mat.get(0).id;
        						bug.grilltime=gtime+10;
        						bug.burger = mat.get(0).burger;
        						
        						bug.intime=mat.get(0).intime;
        						bug.counterid = mat.get(0).counterid;
        						boj.g.add(bug);
        					}
        					
        					diff=diff-p_;
        					p_=0;
        					mat.removeFirst();
        				}
        				else if(diff<p_){
        					
        					for(int m=0;m<diff;m++){
        						burger bug = new burger();
        						bug.customerid=mat.get(0).id;
        						bug.grilltime=gtime+10;
        						bug.burger = mat.get(0).burger;
        						bug.intime=mat.get(0).intime;
        						bug.counterid = mat.get(0).counterid;
        						boj.g.add(bug);
        					}
        					p_=p_-diff;
        					//mat.get(0).burger=mat.get(0).burger-diff;
        					diff=0;
        				}
        				else{
        					for(int m=0;m<p_;m++){
        						burger bug = new burger();
        						bug.customerid=mat.get(0).id;
        						bug.grilltime=gtime+10;
        						bug.burger = mat.get(0).burger;
        						bug.intime=mat.get(0).intime;
        						bug.counterid = mat.get(0).counterid;
        						boj.g.add(bug);
        					}
        					
        					diff=diff-p_;
        					p_=0;
        					mat.removeFirst();
        				}
    				}
    				else{
    					break;
    				}
    			}
    			if(mak==true){
    			
    			bs3.insertData(boj);
    			}
    		}
        }
        
        public void deliverPatty(int gtime){
        	if(bat.size()!=0){
        	while(true){
        		if(bat.get(0).grilltime+1<=gtime){
//        		if(gtime == 13){
//        			System.out.println(bat.get(0).customerid +" "+" nvhv");
//            		
//        		}
        			boolean lal=false;
        			int pay=0;
        			for(int m=0;m<lu.size();m++){
        				if(lu.get(m).id==bat.get(0).customerid){
        					int u=lu.get(m).rcbuger;
        					lu.get(m).rcbuger=u+1;
        					
        					if(lu.get(m).rcbuger==lu.get(m).burger){
        						lal=true;
        						lu.get(m).outtime= gtime;
        						pay=m;
        						bs5.insert(lu.get(m), bs5.root);
        						awt.add(gtime-bat.get(0).intime);
        					}
        					break;
        				}
        				else{
        					;
        				}
        			}
        		if(lal==true){
        			
        			bs1.delete(bat.get(0).customerid);
        			lu.remove(pay);
        		}
//        		Node1 kakaa = new Node1();
//        		kakaa.id = bat.get(0).customerid;
//        		kakaa.intime = bat.get(0).intime;
//        		kakaa.outtime = gtime;
//        		//kakaa.c5.addFirst(kakaa);
//        		bs5.add(kakaa);
////        		
//        		
//        		if(bs1.search(kakaa.id).burger == bs5.search(kakaa.id).c5.size()){
//        			System.out.println(bs1.search(kakaa.id).id+" "+"oo");
//    				awt.add(bs5.search(kakaa.id).c5.get(0).outtime - bs5.search(kakaa.id).c5.get(0).intime);
//    				bs1.delete(kakaa.id);
//    			}
        		bat.removeFirst();
				if(bat.size()==0){
					break;
				}
				
        		}
        		
        		
        		
        	else{
        		break;
        		
				
        	}
        	}
        	}
        	
//        	int u=bat.size();
//        //	Node1 kaka = new Node1();
//    		for(int i=0;i<u;i++){
//    			if(bat.get(0).delitime ==gtime){
////    				if(bat.get(0).customerid==445){
////    					System.out.println(bs1.search(bat.get(0).customerid).rcbuger+" "+"hh");
////    				}
//    				boolean kay = false;
//    				int pay=0;
//    				for(int t=0;t<lu.size();t++){
//    					if(lu.get(t).id  == bat.get(0).customerid){
//    						lu.get(t).rcbuger=lu.get(t).rcbuger+1;
//    						pay=t;
//    						break;
//    					}
//    					else{
//    						;
//    					}
//    				}
//    				if(lu.get(pay).burger==lu.get(pay).rcbuger){
//    					kay=true;
//    					Node1 cc = bs1.search(bat.get(0).customerid);
//    					Node1 cb =cc;
//    					cb.outtime = gtime;
//    					if(bs4.haveId(cb.id)){
//    						bs4.delete(cb.id);
//    						bs4.insert(cb,bs4.root);
//        					bs1.delete(bat.get(0).customerid);
//        					lu.remove(pay);
//    					}
//    					else{
//    						bs4.insert(cb, bs4.root);
//        					bs1.delete(bat.get(0).customerid);
//        					lu.remove(pay);
//    					}
//    				}
//    				if(kay==true){
//    					//lu.remove(pay);
//    				}
    				
//    				if(kay==true){
//    					
//    					Node1 cc = bs1.search(bat.get(0).customerid);
//    					cc.outtime = gtime;
//    					if(bs4.haveId(cc.id)){
//    						bs4.delete(cc.id);
//    						bs4.insert(cc);
//        					bs1.delete(bat.get(0).customerid);
//        					//lu.remove(pay);
//    					}
//    					else{
//    						bs4.insert(cc);
//        					bs1.delete(bat.get(0).customerid);
//        					//lu.remove(pay);
//    					}
//    					
//    					
//    				}
    				
    				    
    					
    					
    				
    				
//    				bat.removeFirst();
//    			}
//    			else{
//    				break;
//    			}
//    		}
    		
        }
        
        public void addCustomer(int tid, int t, int numb){
        	
    			
    			Node1 newnode1 = new Node1();
    			Node1 ne = new Node1();
            	newnode1.intime =t;
//            	if(h.arr[1].q.size()==0){
//            		newnode1.biltime = h.arr[1].counterid;
//            	}
            	//else{
            	newnode1.biltime = t +(h.arr[1].q.size()*h.arr[1].counterid) + h.arr[1].counterid  ;
            	//}
            	ne.id=tid;
            	ne.burger=numb;
            	ne.intime =t;
            	
            	newnode1.id = tid;
            	newnode1.burger= numb;
            	newnode1.bburger=numb;
            	int n = h.arr[1].counterid;
            	newnode1.counterid= n;
            	
            	Node2 newnode2 = new Node2();
            	newnode2.intime =t;
//            	if(h.arr[1].q.size()==0){
//            		newnode2.billtime = h.arr[1].counterid;
//            	}
//            	else{
            	newnode2.billtime = t +(h.arr[1].q.size()*h.arr[1].counterid) + h.arr[1].counterid  ;
            	//}
            	newnode2.id = tid;
            	newnode2.burger= numb;
            	newnode2.bburger= numb;
            	int n1 = h.arr[1].counterid;
            	newnode2.counterid= n1;
            	
            	newnode2.c2.add(newnode2);
            	
            	
            	h.insert(newnode1);
//            	if(id==445){
//            		System.out.println(newnode1.burger+" "+"k");
//            		System.out.println(newnode2.burger+" "+"k");
//            		
//            	}
            	
            	bs2.insertData(newnode2);
            	lu.add(ne);
            	
            	bs1.insert(newnode1, bs1.root);
//            	System.out.println(bs1.currentsize+" "+"ii");
//            	bs1.delete(newnode1.id);
//            	System.out.println(bs1.currentsize+" "+"ik");
//            	
//            	bs1.insert(newnode1, bs1.root);
            	//System.out.println(newnode2.id+" "+"ss");
            	
            	
            	//lu.add(newnode1);
//            	if(id==445){
//            		System.out.println(bs1.search(445).burger+" "+"k");
//            	}
            	
            	
            	
            
            	
//            	if(id==445){
//            		System.out.println(bs2.search(newnode2.billtime).burger+" "+"k");
//            	}
    		
        }
        
        public int customerState(int id, int t){
//        	if(t<138){
//        		if(bs1.search(445)!=null){
//        		System.out.println(bs1.search(445).burger+" , "+t);
//        		}
//        	}
        	int ans=0;
        	if(!bs1.haveId(id)){
        		if(!bs5.haveId(id)){
        			ans = 0;
        			
        		}
        		else{
        			//Node1 nn = bs4.search(id);
        			 ans = this.no_of_counter +2;
        			
        		}
        		
            }else{
            	Node1 nn = bs1.search(id);
            	 if(nn.biltime >t){
            		 ans = nn.counterid ;
            	 }else if(nn.biltime <=t){
            		 ans = this.no_of_counter +1 ;
            	 }
            	 
            	
            }
		
        	 return ans;
    	      
        }
        
        public int griddleWait(int t){
        	int ans =0;
        	for(int i=0;i<mat.size();i++){
        		if(i==0){
        		if(p_!=0){
        			ans=ans+p_;
        		}
        		else{
	        	ans=ans+mat.get(i).burger;
        		}
        		}
        		else{
        			ans=ans+mat.get(i).burger;
        		}
	        }
        	return ans;
        }
}
 
public class MMBurgers implements MMBurgersInterface {
     
     int gtime =0;
     
     resturant r= new resturant();
    

     public boolean isEmpty(){
//    	 if(gtime==23){
//    		 System.out.println(r.bs1.currentsize);
//    	 }
    	 //System.out.println(r.isEmpty());
     	return r.isEmpty();
     	
 	    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");	
     } 
    
    public void setK(int k) throws IllegalNumberException{
        //your implementation
    	if(k>0){
    		r.setK(k);
    	}else{
    		throw new IllegalNumberException("Exception");
    	}
    	
    		
    }   
    
    public void setM(int m) throws IllegalNumberException{
        //your implementation
    	if(m>0){
    		r.setM(m);
    	}
    	else{
    		throw new IllegalNumberException("Exception");
    	}
    	
	   // throw new java.lang.UnsupportedOperationException("Not implemented yet.");	
    } 

    public void advanceTime(int t) throws IllegalNumberException{
        //your implementation
    	if(t <gtime){
    		throw new IllegalNumberException("Exception");
    	}
    	else{
    		if(t!=gtime){
    			int u=0;
    			while(gtime <=t){
    				//System.out.println("abcd");
    				if(u==0){
    					u++;
    				}
    	    		
    				// counter update and getting printed customer to chef
    				else{
    				r.counterUpdate(gtime);
    				
    	    		// removing a cooked patty from the griddle
    	    		
    	    		r.removingPatty(gtime);
    	    		
    	    		
    	    		
    	    		
    	    		
    	    		// adding a  patty to the griddle
    	    		
    	    		r.addingPatty(gtime);
    	    		
    	    		
    	    		
    	    		//Cooked burgers are delivered to customers.
    	    		  
    	    		r.deliverPatty(gtime);
    				}
    	    		
    	    		gtime++;
    	    	}
    			gtime = gtime-1;
    		}
    	}
    	
    	
	    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");	
    } 

    public void arriveCustomer(int id, int t, int numb) throws IllegalNumberException{
        //your implementation
    	if(t< gtime){
    		throw new IllegalNumberException("Exception");
    	}else{
    		
            if(t==gtime){
    			
   			
//    			// adding new customer in a queue
            		//gtime =t; //doubt  t-1
            	if(!r.bs1.haveId(id)&& numb>0){
            		
            	r.addCustomer(id, t, numb);
            		
            	
                }else{
            	   throw new IllegalNumberException("Exception");
                }
                
    	    }
    	    else{
    	    	int u=0;
    			while(gtime <=t){
    				//System.out.println("abcd");
    				if(u==0){
    					u++;
    				}
                    // counter update and getting printed customer to chef
    				else{
    					
    				
    				r.counterUpdate(gtime);
    				
    	    		// removing a cooked patty from the griddle
    	    		
    	    		r.removingPatty(gtime);
    	    		
    	    		
    	    		
    	    		
    	    		
    	    		// adding a  patty to the griddle
    	    		
    	    		r.addingPatty(gtime);
    	    		
    	    		
    	    		
    	    		//Cooked burgers are delivered to customers.
    	    		  
    	    		r.deliverPatty(gtime);
    				}
    	    		
    	    		gtime++;
    	    	}
    			gtime = gtime-1; //doubt  t-1
    			if(!r.bs1.haveId(id)&& numb>0){
            		
                   r.addCustomer(id, t, numb);
                		
                	
                }else{
                	   throw new IllegalNumberException("Exception");
                }
        		
    	    	
    		}
    		
    		
    	}
    } 

    public int customerState(int id, int t) throws IllegalNumberException{
        //your implementation
    	int ans =0;
    	if(t< gtime){
    		throw new IllegalNumberException("Exception");
    	}
//    
    	else{
    		if(t==gtime){
    			
    			ans = r.customerState(id, t);
//    			if(gtime==138){
//    				if(id==445){
//    					System.out.println(r.bs1.search(id).burger +" "+"ll");
//    				}
//    			}
    		}
    		else{
    			int u=0;
    			while(gtime <=t){
    			//	System.out.println("abcd");
    				if(u==0){
    					u++;
    				}
                    // counter update and getting printed customer to chef
    				else{
    				r.counterUpdate(gtime);
    				
    	    		// removing a cooked patty from the griddle
    	    		
    	    		r.removingPatty(gtime);
    	    		
    	    		
    	    		
    	    		
    	    		
    	    		// adding a  patty to the griddle
    	    		
    	    		r.addingPatty(gtime);
    	    		
    	    		
    	    		
    	    		//Cooked burgers are delivered to customers.
    	    		  
    	    		r.deliverPatty(gtime);
    				}
    	    		
    	    		gtime++;
            	}
        		gtime = gtime-1;
            	ans= r.customerState(id, gtime);
    		}
    		//System.out.println(ans +" cs");
        	return ans;
    	}
    	
    	
	    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");	
    } 

    public int griddleState(int t) throws IllegalNumberException{
        //your implementation
    	int ans=0;
    	if(t< gtime){
    		throw new IllegalNumberException("Exception");
    	}else{
    		if(gtime==t){
    			//System.out.println(bs3.currentsize);
    			ans=r.bs3.currentsize;
    		}else{
    			int u=0;
    			while(gtime <=t){
    			//	System.out.println("abcd");
    				if(u==0){
    					u++;
    				}
                     // counter update and getting printed customer to chef
    				else{
    				r.counterUpdate(gtime);
    				
    	    		// removing a cooked patty from the griddle
    	    		
    	    		r.removingPatty(gtime);
    	    		
    	    		
    	    		
    	    		
    	    		
    	    		// adding a  patty to the griddle
    	    		
    	    		r.addingPatty(gtime);
    	    		
    	    		
    	    		
    	    		//Cooked burgers are delivered to customers.
    	    		  
    	    		r.deliverPatty(gtime);
    				}
    	    		
    	    		gtime++;
            	}
    			gtime=gtime-1;
            	ans=r.bs3.currentsize;
    		}
    		//System.out.println(ans +" gs");
    		return ans;
    	
    	}
    	
    	
	   // throw new java.lang.UnsupportedOperationException("Not implemented yet.");	
    } 

    public int griddleWait(int t) throws IllegalNumberException{
        //your implementation
    	int ans=0;
    	if(t< gtime){
    		throw new IllegalNumberException("Exception");
    	}else{
    		if(t==gtime){
    			ans= r.griddleWait(t);
    		}
    		else{
    			int u=0;
    			while(gtime <=t){
    			//	System.out.println("abcd");
    				if(u==0){
    					u++;
    				}
                    // counter update and getting printed customer to chef
    				else{
    				r.counterUpdate(gtime);
    				
    	    		// removing a cooked patty from the griddle
    	    		
    	    		r.removingPatty(gtime);
    	    		
    	    		
    	    		
    	    		
    	    		
    	    		// adding a  patty to the griddle
    	    		
    	    		r.addingPatty(gtime);
    	    		
    	    		
    	    		
    	    		//Cooked burgers are delivered to customers.
    	    		  
    	    		r.deliverPatty(gtime);
    				}
    	    		
    	    		gtime++;
            	}
    			 gtime=gtime-1;
    			 
    			 ans = r.griddleWait(t);
    		}
    		//System.out.println(ans +" gw");
    		return ans;
        
    	}
     } 

    public int customerWaitTime(int id) throws IllegalNumberException{
        //your implementation
    	    int ans = 0;
    		//if(bs1.currentsize ==0){
    			if(r.bs5.haveId(id)){
        			Node1 n = r.bs5.search(id);
        			int t1 = n.intime;
        			int t2 = n.outtime;
        			ans = t2-t1 ;
        			
        			//System.out.println(ans);
            		return ans;
        		}
        		else{
        			throw new IllegalNumberException("Exception");
        		}
//    		}else{
//    			throw new IllegalNumberException(" This is no right time");
//    		}
    		
    		
			 
		
    	
	    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");	
    } 

	public float avgWaitTime(){
        //your implementation
		int sum =0;
		float ans = 0;
		//if(bs1.currentsize ==0){
			for(int i=0; i<r.awt.size();i++){
				sum = sum + r.awt.get(i);
			}
			 ans = (float)sum/r.awt.size();
			 
			//System.out.println(ans);
				return ans;
		//}
		
		
	    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");	
    } 

    
}


