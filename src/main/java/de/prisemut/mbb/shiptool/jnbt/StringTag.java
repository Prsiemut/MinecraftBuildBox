/*    */ package de.prisemut.mbb.shiptool.jnbt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class StringTag
/*    */   extends Tag
/*    */ {
/*    */   private final String value;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public StringTag(String name, String value)
/*    */   {
/* 54 */     super(name);
/* 55 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getValue()
/*    */   {
/* 60 */     return this.value;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 65 */     String name = getName();
/* 66 */     String append = "";
/* 67 */     if ((name != null) && (!name.equals(""))) {
/* 68 */       append = "(\"" + getName() + "\")";
/*    */     }
/* 70 */     return "TAG_String" + append + ": " + this.value;
/*    */   }
/*    */ }


/* Location:              C:\Users\trihebi\Desktop\jnbt-1.1.jar!\org\jnbt\StringTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */